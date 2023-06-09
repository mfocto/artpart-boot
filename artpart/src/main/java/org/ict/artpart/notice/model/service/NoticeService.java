package org.ict.artpart.notice.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
import org.ict.artpart.common.Pagination;
import org.ict.artpart.common.SearchCondition;
import org.ict.artpart.notice.entity.NoticeEntity;
import org.ict.artpart.notice.entity.NoticeRepository;
import org.ict.artpart.notice.entity.NoticeRepositoryCustom;
import org.ict.artpart.notice.model.dto.NoticeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;
    private final NoticeRepositoryCustom noticeRepositoryCustom;
    //공지글 목록
    public Header<List<NoticeDto>> getNoticeList(
            Pageable pageable, SearchCondition searchCondition) {
        List<NoticeDto> list = new ArrayList<>();

        Page<NoticeEntity> noticeEntities = noticeRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);

        for(NoticeEntity entity : noticeEntities){
            NoticeDto dto = NoticeDto.builder()
                    .noticeidx(entity.getNoticeidx())
                    .writer(entity.getWriter())
                    .title(entity.getTitle())
                    .content(entity.getContent())
                    .noticeDate(entity.getNoticeDate())
                    .build();

            list.add(dto);

        }

        Pagination pagination = new Pagination(
                (int) noticeEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 15

        );
        return Header.OK(list, pagination);
    }

    //공지글 상세보기
    public NoticeDto getNotice(Long id) {
        NoticeEntity entity = noticeRepository.findById(id).orElseThrow(() -> new RuntimeException("공지글을 찾을 수 없습니다."));
                return NoticeDto.builder()
                        .noticeidx(entity.getNoticeidx())
                        .writer(entity.getWriter())
                        .title(entity.getTitle())
                        .content(entity.getContent())
                        .noticeDate(entity.getNoticeDate())
                        .build();
    }
    //메인페이지 최신공지글 3개
    public Header<List<NoticeDto>> getNoticeTop3() {
        List<NoticeDto> list = new ArrayList<>();
        List<NoticeEntity> top3 = noticeRepository.findByTop3List();
        for(NoticeEntity entity : top3){
            NoticeDto dto = NoticeDto.builder()
                    .noticeidx(entity.getNoticeidx())
                    .noticeDate(entity.getNoticeDate())
                    .content(entity.getContent())
                    .writer(entity.getWriter())
                    .title(entity.getTitle())
                    .build();
            list.add(dto);
        }
        return Header.OK(list);
    }
}
