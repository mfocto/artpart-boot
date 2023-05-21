package org.ict.artpartM.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.member.entity.MemberEntity;
import org.ict.artpartM.member.model.dto.MemberDto;
import org.ict.artpartM.member.model.service.MemberService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/list")
    public Header<List<MemberDto>> memberList(
            @PageableDefault(sort = {"memberidx"}) Pageable pageable,
            SearchCondition searchCondition) {
        return memberService.getMemberList(pageable, searchCondition);
    }

    @GetMapping("/member/{id}")
    public MemberDto getMember(@PathVariable Long id) { return memberService.getMember(id); }

    @PostMapping("/member")
    public MemberEntity create(@RequestBody MemberDto memberDto) {
        MemberEntity member = memberService.create(memberDto);
        return member;
    }

    @PatchMapping("/member")
    public MemberEntity update(@RequestBody MemberDto memberDto) { return memberService.update(memberDto); }

    @DeleteMapping("/member/{id}")
    public void delete(@PathVariable Long id) { memberService.delete(id); }




}
