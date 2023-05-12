package org.ict.artpartM.account.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MreportRepository extends JpaRepository<MreportEntity, Long> {
    MreportEntity findByTMIdx(long tmIdx);
}
