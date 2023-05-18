package org.ict.artpartM.notice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.notice.entity.NoticeEntity;
import org.ict.artpartM.notice.model.dto.NoticeDto;
import org.ict.artpartM.notice.model.service.NoticeService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class NoticeController {
    private final NoticeService noticeService;
    // 목록 조회용
    @GetMapping("/notice/list")
    public Header<List<NoticeDto>> noticeList(
            @PageableDefault(sort = {"noticeidx"})Pageable pageable,
            SearchCondition searchCondition) {
        return noticeService.getNoticeList(pageable, searchCondition);
    }

    // 상세보기용
    @GetMapping("/notice/{id}")
    public NoticeDto getNotice(@PathVariable Long id) { return noticeService.getNotice(id); }
    // 작성용
    @PostMapping("/notice")
    public NoticeEntity create(@RequestBody NoticeDto noticeDto) { return noticeService.create(noticeDto); }
    // 수정용
    @PatchMapping("/notice")
    public NoticeEntity update(@RequestBody NoticeDto noticeDto) { return noticeService.update(noticeDto); }
    // 삭제용
    @DeleteMapping("/notice/{id}")
    public void delete(@PathVariable Long id) { noticeService.delete(id); }
}
