package org.ict.artpart.member.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.member.entity.MemberRepository;
import org.ict.artpart.member.model.dto.MemberDto;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;



    public MemberDto login(String memberId, String memberPassword) {
        System.out.println(memberId +  memberPassword);
        if (memberId == null) {
            return null;
        }

//        MemberEntity m = memberRepository.findByMemberId(memberId);
//        memberDto.setMemberHo(m.getMemberHo());
//        memberDto.setMemberName(m.getMemberName());
//        memberDto.setMemberPhone(m.getMemberPhone());
//        memberDto.setMemberLoginOK(m.getMemberLoginOK());
//        memberDto.setMemberDong(m.getMemberDong());
//        memberDto.setMemberId(m.getMemberId());
//        memberDto.setMemberPassword(m.getMemberPassword());
//        memberDto.setMemberIdx(m.getMemberIdx());

        if (memberPassword.equals(memberRepository.findByMemberId(memberId).getMemberPassword())){

            return MemberDto.builder()
                    .memberIdx(memberRepository.findByMemberId(memberId).getMemberIdx())
                    .aptIdx(memberRepository.findByMemberId(memberId).getAptIdx().getAptIdx())
                    .memberDong(memberRepository.findByMemberId(memberId).getMemberDong())
                    .memberName(memberRepository.findByMemberId(memberId).getMemberName())
                    .memberHo(memberRepository.findByMemberId(memberId).getMemberHo())
                    .memberId(memberRepository.findByMemberId(memberId).getMemberId())
                    .memberPassword(memberRepository.findByMemberId(memberId).getMemberPassword())
                    .memberPhone(memberRepository.findByMemberId(memberId).getMemberPhone())
                    .memberLoginOK(memberRepository.findByMemberId(memberId).getMemberLoginOK())
                    .memberMyCar1(memberRepository.findByMemberId(memberId).getMemberMyCar1())
                    .memberMyCar2(memberRepository.findByMemberId(memberId).getMemberMyCar2())
                    .build();
        } else {
            return null;
        }
    } //login () close


}
