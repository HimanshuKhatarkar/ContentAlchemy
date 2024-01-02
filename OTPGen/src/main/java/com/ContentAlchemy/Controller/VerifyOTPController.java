package com.ContentAlchemy.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ContentAlchemy.dto.StoreOTP;
import com.ContentAlchemy.dto.TempOTP;

@RestController
public class VerifyOTPController {
    @PostMapping("/otp")
    public String verifyOTP(@RequestBody TempOTP sms) {
        StoreOTP store = new StoreOTP();
        if(sms.getOtp() == store.getOtp()){
            return "OTP is correct";
        }else{
            return "OTP is wrong";
        }

            
    }
}
