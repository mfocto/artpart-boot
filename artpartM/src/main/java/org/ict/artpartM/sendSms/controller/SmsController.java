package org.ict.artpartM.sendSms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.ict.artpartM.sendSms.model.dto.MessageDTO;
import org.ict.artpartM.sendSms.model.dto.SmsResponseDTO;
import org.ict.artpartM.sendSms.model.service.SmsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Controller
@RequiredArgsConstructor
public class SmsController {

    private final SmsService smsService;



    @PostMapping("/sms/send")
    public SmsResponseDTO sendSms(@RequestParam(name="content")String content) throws JsonProcessingException, RestClientException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDTO messageDto = new MessageDTO();
        messageDto.setContent(content);
        for(int i=0; i<3; i++){
        if(i==0){
            messageDto.setTo("01088964808");
        } else if (i==1) {
            messageDto.setTo("01083869389");
        }else{
            messageDto.setTo("01083869389");
        }


            smsService.sendSms(messageDto);
        }
        return null;
    }
}
