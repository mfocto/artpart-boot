package org.ict.artpart.member.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
import org.ict.artpart.member.entity.MemberEntity;
import org.ict.artpart.member.model.dto.MemberDto;
import org.ict.artpart.member.model.service.MemberService;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class MemberController {
    private final MemberService memberService;


    @PostMapping("/testinsert")
    public Header<MemberEntity> test(){
        return Header.OK(memberService.test());
    }

    @GetMapping("/member/{id}")
    public Header<MemberDto> getMember(@PathVariable String memberId){
        return Header.OK(memberService.getMember(memberId));
    }

}

