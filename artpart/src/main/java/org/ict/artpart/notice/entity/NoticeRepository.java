package org.ict.artpart.notice.entity;

import org.ict.artpart.notice.model.dto.NoticeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
    @Query(value = "SELECT * FROM " +
            "(SELECT NOTICEIDX, WRITER, TITLE, CONTENT, NOTICEDATE, " +
            "ROW_NUMBER() OVER (ORDER BY NOTICEIDX DESC) AS rn " +
            "FROM NOTICE) " +
            "WHERE rn <= 3", nativeQuery = true)
    List<NoticeEntity> findByTop3List();
}
