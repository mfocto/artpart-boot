package org.ict.artpart.notice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
import org.ict.artpart.common.SearchCondition;
import org.ict.artpart.notice.model.dto.NoticeDto;
import org.ict.artpart.notice.model.service.NoticeService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class NoticeController {
    private final NoticeService noticeService;

    //공지글 목록 가져오기
    @GetMapping("/notice/list")
    public Header<List<NoticeDto>> noticeList(
            @PageableDefault(sort = {"NOTICEIDX"}) Pageable pageable,
            SearchCondition searchCondition){
        return noticeService.getNoticeList(pageable, searchCondition);
    }

    //공지글 상세 보기
    @GetMapping("/notice/{id}")
    public NoticeDto getNotice(@PathVariable Long id){
        return noticeService.getNotice(id);
    }

    //최근 공지긍 3개 보기
    @GetMapping("/member/main")
    public List<NoticeDto> noticeTop3List(){
        log.info("1111111");
        return noticeService.getNoticeTop3();
    }
}
