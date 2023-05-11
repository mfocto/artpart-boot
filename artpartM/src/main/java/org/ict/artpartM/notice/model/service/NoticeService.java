package org.ict.artpartM.notice.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.Pagination;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.notice.entity.NoticeEntity;
import org.ict.artpartM.notice.entity.NoticeRepository;
import org.ict.artpartM.notice.entity.NoticeRepositoryCustom;
import org.ict.artpartM.notice.model.dto.NoticeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final NoticeRepositoryCustom noticeRepositoryCustom;

    public Header<List<NoticeDto>> getNoticeList(
            Pageable pageable, SearchCondition searchCondition){
        List<NoticeDto> dtos = new ArrayList<>();

        Page<NoticeEntity> noticeEntities = noticeRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for(NoticeEntity entity : noticeEntities){
            NoticeDto dto = NoticeDto.builder()
                    .noticeidx(entity.getNoticeidx())
                    .writer(entity.getWriter())
                    .title(entity.getTitle())
                    .content(entity.getContent())
                    .noticedate(entity.getNoticedate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .build();

            dtos.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) noticeEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 15
        );

        return Header.OK(dtos, pagination);
    }

    // 공지글 가져오기
    public NoticeDto getNotice(Long id){
        NoticeEntity entity = noticeRepository.findById(id).orElseThrow(() -> new RuntimeException("공지글을 찾을 수 없습니다."));
        return NoticeDto.builder()
                .noticeidx(entity.getNoticeidx())
                .title(entity.getTitle())
                .writer(entity.getWriter())
                .content(entity.getContent())
                .noticedate(entity.getNoticedate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .build();
    }

    //공지글 등록
    public NoticeEntity create(NoticeDto noticeDto){
        NoticeEntity entity = NoticeEntity.builder()
                .title(noticeDto.getTitle())
                .content(noticeDto.getContent())
                .writer(noticeDto.getWriter())
                .noticedate(LocalDateTime.now())
                .build();
        return noticeRepository.save(entity);
    }

    //공지글 수정
    public NoticeEntity update(NoticeDto noticeDto){
        NoticeEntity entity = noticeRepository.findById(noticeDto.getNoticeidx()).orElseThrow(() -> new RuntimeException("공지글을 찾을 수 없읍니다."));
        entity.setTitle(noticeDto.getTitle());
        entity.setContent(noticeDto.getContent());
        entity.setNoticedate(LocalDateTime.now());
        return noticeRepository.save(entity);
    }

    //공지글 삭제
    public void delete(Long id){
        NoticeEntity entity = noticeRepository.findById(id).orElseThrow(() -> new RuntimeException("공지글을 찾을 수 없습니다."));
        noticeRepository.delete(entity);
    }
}
