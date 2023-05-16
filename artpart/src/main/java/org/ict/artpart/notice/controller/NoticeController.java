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

    @GetMapping("notice/list")
    public Header<List<NoticeDto>> noticeList(
            @PageableDefault(sort = {"NOTICEDATE"}) Pageable pageable,
            SearchCondition searchCondition){
        return noticeService.getNoticeList(pageable, searchCondition);
    }
}
