package org.ict.artpartM.notice.entity;


import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
    NoticeEntity findByNoticeidx(long noticeidx);
}
