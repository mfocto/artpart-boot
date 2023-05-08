package org.ict.artpart.member.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.member.entity.MemberEntity;
import org.ict.artpart.member.entity.MemberRepository;
import org.ict.artpart.member.model.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Member login(String memberid, String memberpwd) {
        if (memberid == null) {
            return null;
        }
        Member member = new Member();
        MemberEntity m = memberRepository.findByMemberId(memberid);
        member.setMemberHo(m.getMemberHo());
        member.setMemberAdd(m.getMemberAdd());
        member.setMemberName(m.getMemberName());
        member.setMemberPhone(m.getMemberPhone());
        member.setMemberLoginOK(m.getMemberLoginOK());
        member.setMemberDong(m.getMemberDong());
        member.setMemberId(m.getMemberId());
        member.setMemberPw(m.getMemberPw());
        member.setMemberIdx(m.getMemberIdx());

        if (memberpwd.equals(member.getMemberPw())){
            return member;
        } else {
            return null;
        }
    }
}
