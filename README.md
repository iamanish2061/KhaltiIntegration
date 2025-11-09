Hello!
This is payment integration of Khalti in spring boot

First of all go through the khalti documentation
https://docs.khalti.com/khalti-epayment/

You will have the knowledge regarding from here:
https://docs.khalti.com/getting-started/

First of all, create merchant account (for sandbox access)
https://test-admin.khalti.com/#/join/merchant

After creating the account, log in with your credentials.
After that use 987654 as login OTP.

You will get access to the live-secret-key, use that in application.properties


Login credentials while logging in as user/customer
Test Khalti ID for 9800000000 9800000001 9800000002 9800000003 9800000004 9800000005
Test MPIN 1111
Test OTP 987654


Guidance of my code

1. pom.xml file
   this includes all required dependencies like Web...

2.resources/application.properties
the fields of KhaltiConfig.java class is initialized here.

3.resources/static folder
index.html - ui for sending post request (to start payment)
success.html - ui that is redirected after successful payment
failure.html - ui that is redirected after payment is failed

4.classes
KhaltiIntegrationApplication.java - main class with bean for RestTemplate (creates object for reusablilty)
KhaltiConfig.java -  contains special field required to khalti while carrying out operation
                        contains methods for generating unique id
GlobalExceptionHandler - for handling exception that occurs throughout the program

KhaltiRequest - entity that contains fields required for sending request to khalti,
KhaltiResponse - contains fields that is sent by khalti as a response (first response tht gives url and we have to redirect the user to that url)
KhaltiCallbackDTO - contains fields that is sent by khalti as a response (second response after success/failed payment)

KhaltiController - contains end points , to handle initial pay request and to handle response sent by khalti
KhaltiService - methods that is used to send first request to khalti for getting payment url in which we redirect users to
                - method to sent another request to khalti for veryfying paymeny

