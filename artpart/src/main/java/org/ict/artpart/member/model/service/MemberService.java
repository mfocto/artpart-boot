package org.ict.artpart.member.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.member.entity.MemberEntity;
import org.ict.artpart.member.entity.MemberRepository;
import org.ict.artpart.member.model.dto.MemberDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    public MemberEntity test(){
        MemberEntity entity = MemberEntity.builder()
                .memberId("so여물")
                .memberPassword(passwordEncoder.encode("duanf"))
                .memberName("송영욱")
                .memberPhone("01083869389")
                .memberLoginOK("Y")
                .memberAuth("ROLE_MEMBER")
                .build();

        return memberRepository.save(entity);
    }

    public MemberDto getMember(String memberId) {
        MemberEntity entity = memberRepository.findByMemberId(memberId);
        MemberDto dto = MemberDto.builder()
                .memberIdx(entity.getMemberIdx())
                .memberId(entity.getMemberId())
                .memberName(entity.getMemberName())
                .memberPhone(entity.getMemberPhone())
                .memberLoginOK(entity.getMemberLoginOK())
                .build();
        return dto;
    }
}
