package org.ict.artpart.minone.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.member.model.dto.MemberDto;
import org.ict.artpart.minone.model.dto.MinoneDto;
import org.ict.artpart.minone.model.entity.MinoneEntity;
import org.ict.artpart.minone.model.service.MinoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(value ="/minone" , method = RequestMethod.GET)      // "/localhost에서 접속 시 뭐로 구분할건지" > localhost:8080/test 이런 식으로 사용하게 됨
public class MinoneController {
    private final MinoneService service;


    //########################################################################
    //민원 정보 리스트 조회
    @GetMapping(value ="")
    public ResponseEntity<List<MinoneEntity>> list() throws Exception {
        log.info("list");

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    //########################################################################
    //1명이 작성한 게시글 모두 조회 =>getBoardsByMember 메서드에 매핑
    @GetMapping(value ="pagemyminone")
    public List<MinoneDto> getMinoneByMember(@PathVariable Long memberIdx) {
        return service.getMinoneByMemberIdx(memberIdx);
    }


    //########################################################################
    //특정 게시글 번호에 해당하는 게시글정보 조회
    @GetMapping("/{minIdx}")
    public ResponseEntity<MinoneEntity> read(@PathVariable("minIdx") Long minIdx) throws Exception {
        log.info("read");

        MinoneEntity minoneEntity = service.read(minIdx);

        return new ResponseEntity<>(minoneEntity, HttpStatus.OK);
    }


    //########################################################################
    //민원 등록
    @PreAuthorize("hasRole('MEMBER')")  //"MEMBER" 역할을 가진 사용자만이 액세스 할 수 있도록 보장
    @PostMapping
    public ResponseEntity<MinoneDto> register(@Validated                                            //데이터가 유효성 검사(ex. 누락, 최대 크기 초과 등)
                                                                    @RequestBody MinoneEntity minoneEntity,       //"MinoneDto" 유형의 객체를받아옴 "RequestBody"에
                                                                    @AuthenticationPrincipal MemberDto memberdto) throws Exception {
        //  "MemberDto" 유형의 개체를 가져 오는 "AuthenticationPrincipal" 주석을 사용하여 유효성이 검사 된 새 "Minone" 객체를 등록함. 메서드는 "Minone" 객체를 반환하는 "MinoneEntity" 객체를 반환

        String memberId = memberdto.getMemberId();
        //"MemberDto" 객체에서 현재 인증 된 사용자의 사용자 ID를 검색

        log.info("register memberId = " + memberId);
        //확인

        //minone.setWriter(memberId);
        //새 "minone" 객체의 작성자를 현재 인증 된 사용자의 사용자 ID로 설정 => 본인만 작성가능한 폼이므로 필요없음

        service.register(minoneEntity);
        //새 "minone" 객체를 등록하는 서비스 클래스의 인스턴스인 "minoneService"안의 객체를 호출

        log.info("새로 등록 된 민원게시물 번호 확인 (register board.getMinIdx())= " + minoneEntity.getMinIdx());
        //새로 등록 된 민원게시물 번호 확인

        MinoneEntity createdMinone = service.read(minoneEntity.getMinIdx());
        //"service" 에서 방금 등록 된 민원게시물에 해당하는 "Minone" 객체를 검색

        return new ResponseEntity<>(createdMinone.toDto(), HttpStatus.OK);
        //수정 된 "Minone" 객체와 HTTP 상태 코드 200 (OK)을 포함하는 새 "ResponseEntity" 객체를 생성합니다.
        // 이 객체는 메서드에서 반환되며 사용자의 HTTP POST 요청의 응답으로 보내짐
    }




}
