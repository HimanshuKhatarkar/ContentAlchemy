package com.ContentAlchemy.Service;

import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.ContentAlchemy.dto.SmsPojo;
import com.ContentAlchemy.dto.StoreOTP;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component
public class SmsService {
    private final String ACCOUNT_SID="AC40e86fa8418f55ea0506364b6cc42b47";

    private final String AUTH_TOKEN= "cde7d7614fa5fd526f66747315e01bef";

    private final String FROM_NUMBER = "+13343844622" ;

    public void send (SmsPojo sms) throws ParseException { 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        int min=100000;

        int max=999999;

        int number=(int)(Math.random()*(max-min+1)+min);

        String msg="Your OTP" +number;

        Message message = Message.creator(new PhoneNumber(sms.getPhoneNo()), new PhoneNumber (FROM_NUMBER), msg).create();

        System.out.println(message);
        // Save the current OTP Number for Validation; 
        StoreOTP store = new StoreOTP();

        store.setOtp(number);

        /*Date myDate=new Date();

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy/v/dd HH:mm:ss");

        Date date=sdf. parse(myDate.toString());

        long millis=date. getTime(); 
        
        System.out.println(millis);

        SmsPojo.setotp(number);

        System.out.println("here is my id: " message.getsid());// Unique resource ID created to manage this transaction
        */

    }

        
    public void receive(MultiValueMap<String, String> smscallback) {

    }
    
}