package com.ContentAlchemy.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ContentAlchemy.Service.SmsService;
import com.ContentAlchemy.dto.SmsPojo;

@RestController
public class SMSController {
    @Autowired
    SmsService service;

    @Autowired 
    private SimpMessagingTemplate websocket;



    private final String TOPIC_DESTINATION = "/lesson/sms";

    //You can send Ss in verified Number

    @PostMapping("/mobileNo")    
    public ResponseEntity<Boolean> smsSubmit (@RequestBody SmsPojo sms){

        try{

            System.out.println("hello"); 
            service.send(sms);
            System.out.println("hello");

        }catch(Exception e){

            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        websocket.convertAndSend (TOPIC_DESTINATION, gettimestamp() +" SMS has been sent!: "+ sms.getPhoneNo());

        return new ResponseEntity<Boolean> (true, HttpStatus.OK); 
    }

    @RequestMapping ( value = "/smscallback", method =RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)

    public void smscallback(@RequestBody MultiValueMap<String, String> map) {
        service.receive(map);

        websocket.convertAndSend (TOPIC_DESTINATION, gettimestamp()+ " Twillo has made a callback request! Here are the contents: "+ map.toString());
    }

    private String gettimestamp() {

        return DateTimeFormatter. ofPattern("yyyy-mm-dd hh:mm:ss").format(LocalDateTime.now());

    }

    // @PostMapping("/mobileNumber")
    // public ResponseEntity<String> sendOtp(@RequestBody SmsPojo sms) {
    //     try {
    //         System.out.println("Received phone number: " + sms.getPhoneNo());
    //         // Add code to send OTP here
    //         return new ResponseEntity<>("Successfully OTP sent to your Mobile Number.", HttpStatus.OK);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return new ResponseEntity<>("Failed to send OTP.", HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }
}

