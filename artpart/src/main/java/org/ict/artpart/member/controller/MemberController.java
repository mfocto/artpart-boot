package org.ict.artpart.member.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
import org.ict.artpart.member.model.dto.MemberDto;
import org.ict.artpart.member.model.service.MemberService;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login/{memberid}")
    public Header<MemberDto> login(@PathVariable String memberid, @RequestParam("memberpwd") String memberpwd){
        System.out.println(memberid);
        MemberDto member = memberService.login(memberid, memberpwd);
        if(member != null){
            return Header.OK(member);
        } else {
            return Header.ERROR("로그인 실패");
        }
    }
}