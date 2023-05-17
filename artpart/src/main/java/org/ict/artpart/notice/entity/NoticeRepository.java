package org.ict.artpart.notice.entity;

import org.ict.artpart.notice.model.dto.NoticeDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
}
