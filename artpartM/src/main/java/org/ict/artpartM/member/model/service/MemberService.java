package org.ict.artpartM.member.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.Pagination;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.member.entity.MemberEntity;
import org.ict.artpartM.member.entity.MemberRepository;
import org.ict.artpartM.member.entity.MemberRepositoryCustom;
import org.ict.artpartM.member.model.dto.MemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberRepositoryCustom memberRepositoryCustom;
    private final PasswordEncoder passwordEncoder;

    public Header<List<MemberDto>> getMemberList(
            Pageable pageable, SearchCondition searchCondition){
        List<MemberDto> dtos = new ArrayList<>();

        Page<MemberEntity> memberEntities = memberRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for(MemberEntity entity : memberEntities){
            MemberDto dto = MemberDto.builder()
                    .memberidx(entity.getMemberidx())
                    .memberdong(entity.getMemberdong())
                    .memberho(entity.getMemberho())
                    .membername(entity.getMembername())
                    .memberid(entity.getMemberid())
                    .memberpassword(entity.getMemberpassword())
                    .memberphone(entity.getMemberphone())
                    .memberloginok(entity.getMemberloginok())
                    .membermycar1(entity.getMembermycar1())
                    .membermycar2(entity.getMembermycar2())
                    .aptidx(entity.getAptidx())
                    .build();

            dtos.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) memberEntities.getTotalElements()
                ,pageable.getPageNumber() + 1
                ,pageable.getPageSize()
                ,15
        );

        return Header.OK(dtos,pagination);
    }

    //입주민정보 가져오기
  public MemberDto getMember(Long id){
        MemberEntity entity = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("입주민 정보가 없습니다."));
        return MemberDto.builder()
                .memberidx(entity.getMemberidx())
                .memberdong(entity.getMemberdong())
                .memberho(entity.getMemberho())
                .membername(entity.getMembername())
                .memberid(entity.getMemberid())
                .memberpassword(entity.getMemberpassword())
                .memberphone(entity.getMemberphone())
                .memberloginok(entity.getMemberloginok())
                .membermycar1(entity.getMembermycar1())
                .membermycar2(entity.getMembermycar2())
                .aptidx(entity.getAptidx())
                .build();
    }

    //등록
    public MemberEntity create(MemberDto memberDto){
        MemberEntity entity = MemberEntity.builder()
                .memberidx(memberDto.getMemberidx())
                .memberdong(memberDto.getMemberdong())
                .memberho(memberDto.getMemberho())
                .membername(memberDto.getMembername())
                .memberid(memberDto.getMemberid())
                .memberpassword(passwordEncoder.encode(memberDto.getMemberpassword() != null ? memberDto.getMemberpassword() : "0"))
                .memberphone(memberDto.getMemberphone())
                .memberloginok(memberDto.getMemberloginok())
                .membermycar1(memberDto.getMembermycar1())
                .membermycar2(memberDto.getMembermycar2())
                .aptidx(memberDto.getAptidx())
                .memberauth("ROLE_MEMBER")
                .build();
                return memberRepository.save(entity);
    }

    //수정
    public MemberEntity update(MemberDto memberDto){
        MemberEntity entity = memberRepository.findByMemberidx(memberDto.getMemberidx());
        entity.setMembername(memberDto.getMembername());
        entity.setMemberid(memberDto.getMemberid());
        entity.setMemberpassword(passwordEncoder.encode(memberDto.getMemberpassword() != null ? memberDto.getMemberpassword() : "0"));
        entity.setMemberphone(memberDto.getMemberphone());
        entity.setMemberloginok(memberDto.getMemberloginok());
        entity.setMembermycar1(memberDto.getMembermycar1());
        entity.setMembermycar2(memberDto.getMembermycar2());
        entity.setAptidx(memberDto.getAptidx());
        return memberRepository.save(entity);
    }

    //삭제
    public void delete(Long id){
        MemberEntity entity = memberRepository.findById(id).orElseThrow(()-> new RuntimeException("입주민 정보를 찾을 수 없습니다."));
          memberRepository.delete(entity);
    }



}
