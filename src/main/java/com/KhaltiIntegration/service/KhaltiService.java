package com.KhaltiIntegration.service;

import com.KhaltiIntegration.config.KhaltiConfig;
import com.KhaltiIntegration.entity.KhaltiCallbackDTO;
import com.KhaltiIntegration.entity.KhaltiRequest;
import com.KhaltiIntegration.entity.KhaltiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Service
public class KhaltiService {

    @Autowired
    private KhaltiConfig config;

    @Autowired
    private RestTemplate restTemplate;

    public KhaltiRequest initializeRequestFields() {
        //i have used dummy data
        //you can fetch from database or perform you logic
        return new KhaltiRequest(BigDecimal.valueOf(1000), config.generateUniqueId(), "Order1");
    }

    public KhaltiResponse initiatePayment(KhaltiRequest khalti){
        // Request body as per stated by khalti
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("return_url", config.getCallbackUrl());
        requestBody.put("website_url", config.getWebsiteUrl());
        requestBody.put("amount", khalti.getAmount()); // amount in paisa (e.g., Rs 100 = 10000)
        requestBody.put("purchase_order_id", khalti.getPurchase_order_id());
        requestBody.put("purchase_order_name", khalti.getPurchase_order_name());

        // Headers (we need to specify authorizatoin too)
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Key " + config.getLiveSecretKey());

        // Combining both of above
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        // Sending POST request to khalti and mapping the response to KhaltiResponse Class
        ResponseEntity<KhaltiResponse> response = restTemplate.exchange(config.getInitialUrl(), HttpMethod.POST, entity, KhaltiResponse.class);

        return response.getBody();
    }

    public boolean verifyPayment(KhaltiCallbackDTO response){

        //checking if the status is completed
        if(!"COMPLETED".equalsIgnoreCase(response.getStatus())){
            return false;
        }

        //for verification f the payment
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Key "+config.getLiveSecretKey());

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("pidx", response.getPidx());
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<Map> verificationResponse = restTemplate.postForEntity(config.getVerifyUrl(), entity, Map.class);

            if (verificationResponse.getStatusCode() == HttpStatus.OK && verificationResponse.getBody() != null) {
                Map<String,Object> body = verificationResponse.getBody();

                String status = (String) body.get("status");
                String transactionId = (String) body.get("transaction_id");
                if(!transactionId.isEmpty() && transactionId.equalsIgnoreCase(response.getTransaction_id()) && status.equalsIgnoreCase("Completed")){
                    //database operation
                    String amount = (String) body.get("total_amount");

                    System.out.println("Valid payment of Rs:"+amount);
                    return true;
                }else{
                    //db operation
                    System.out.println("Invalid payment");
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("Error while verifying payment! "+ e.getMessage());
        }
        return false;
    }


}
