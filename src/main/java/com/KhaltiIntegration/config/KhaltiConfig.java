package com.KhaltiIntegration.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
@ConfigurationProperties(prefix = "khalti")
public class KhaltiConfig {
    private String liveSecretKey;
    private String livePublicKey;
    private String verifyUrl;
    private String initialUrl;
    private String websiteUrl;
    private String callbackUrl;

    public String getInitialUrl() {
        return initialUrl;
    }

    public void setInitialUrl(String initialUrl) {
        this.initialUrl = initialUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }


    public KhaltiConfig() {}

    public KhaltiConfig(String liveSecretKey, String livePublicKey, String baseUrl, String callbackUrl, String initialUrl, String websiteUrl) {
        this.liveSecretKey = liveSecretKey;
        this.livePublicKey = livePublicKey;
        this.verifyUrl = baseUrl;
        this.callbackUrl=callbackUrl;
        this.initialUrl=initialUrl;
        this.websiteUrl =websiteUrl;
    }

    public String getLiveSecretKey() {return liveSecretKey;}

    public void setLiveSecretKey(String liveSecretKey) {
        this.liveSecretKey = liveSecretKey;
    }

    public String getLivePublicKey() {
        return livePublicKey;
    }

    public void setLivePublicKey(String livePublicKey) {
        this.livePublicKey = livePublicKey;
    }

    public String getVerifyUrl() {
        return verifyUrl;
    }

    public void setVerifyUrl(String verifyUrl) {
        this.verifyUrl = verifyUrl;
    }

    public String generateUniqueId(){
        return UUID.randomUUID().toString();
    }

}
