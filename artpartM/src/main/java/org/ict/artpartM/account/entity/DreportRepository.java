package org.ict.artpartM.account.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DreportRepository extends JpaRepository<DreportEntity, Long> {
    DreportEntity findByTDIdx(long tdIdx);
}
