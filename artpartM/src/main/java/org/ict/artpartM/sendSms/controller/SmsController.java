package org.ict.artpartM.sendSms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.ict.artpartM.member.entity.MemberEntity;
import org.ict.artpartM.member.entity.MemberRepository;
import org.ict.artpartM.sendSms.model.dto.MessageDTO;
import org.ict.artpartM.sendSms.model.dto.SmsResponseDTO;
import org.ict.artpartM.sendSms.model.service.SmsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SmsController {

    private final MemberRepository memberRepository;
    private final SmsService smsService;



    @PostMapping("/sms/send")
    public SmsResponseDTO sendSms(@RequestParam(name="content")String content) throws JsonProcessingException, RestClientException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDTO messageDto = new MessageDTO();
        messageDto.setContent(content);
        List<MemberEntity> memberEntities = memberRepository.findAll().stream()
                .filter(member -> "Y".equals(member.getMemberloginok()))
                .filter(member -> member.getMemberphone() != null)
                .collect(Collectors.toMap(MemberEntity::getMemberphone, Function.identity(), (existing, replacement) -> existing))
                .values()
                .stream()
                .collect(Collectors.toList());

        for(MemberEntity entity : memberEntities){
            messageDto.setTo(entity.getMemberphone());
            smsService.sendSms(messageDto);
        }

        return new SmsResponseDTO();
    }
}
