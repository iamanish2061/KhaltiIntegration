package com.KhaltiIntegration.controller;

import com.KhaltiIntegration.entity.KhaltiCallbackDTO;
import com.KhaltiIntegration.entity.KhaltiRequest;
import com.KhaltiIntegration.entity.KhaltiResponse;
import com.KhaltiIntegration.service.KhaltiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@RestController
public class KhaltiController {

    @Autowired
    private KhaltiService khaltiService;

    @PostMapping("/pay-with-khalti")
    public RedirectView payWithKhalti() throws IOException {
        //do processing as you like according to need
        KhaltiRequest khaltiRequest = khaltiService.initializeRequestFields();
        KhaltiResponse khaltiResponse = khaltiService.initiatePayment(khaltiRequest);
//        khalti response looks like this
//        {
//            "pidx":"SUBnBvcSFtG2NxL59yqkEY",
//            "payment_url":"https://test-pay.khalti.com/?pidx=SUBnBvcSFtG2NxL59yqkEY",
//            "expires_at":"2025-11-09T14:27:12.729303+05:45",
//            "expires_in":1800
//        }

//        save or do what you want to do
//        but remember you have to redirect user to the received payment url
        String paymentRedirectionUrl = khaltiResponse.getPayment_url();
        return new RedirectView(paymentRedirectionUrl);
    }



    //response from khalti after successful payment
    // https://localhost:8080/khalti-response-handle?
    // pidx=CAj64F2F4vi33wWF3mQCk8
    // &transaction_id=gJPuobwjzZx7UsqeZMFBwZ
    // &tidx=gJPuobwjzZx7UsqeZMFBwZ
    // &txnId=gJPuobwjzZx7UsqeZMFBwZ
    // &amount=1000
    // &total_amount=1000
    // &mobile=98XXXXX003
    // &status=Completed
    // &purchase_order_id=954a3bff-5715-4bca-acbb-fe1c607f16b4
    // &purchase_order_name=Order1
    @GetMapping("/khalti-response-handle")
    public RedirectView handleResponse(KhaltiCallbackDTO values){
        boolean isVerified = khaltiService.verifyPayment(values);
        if(isVerified)
            return new RedirectView("/success.html");
        else
            return new RedirectView("/failure.html");
    }


}
