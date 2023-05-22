package org.ict.artpartM.account.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlipRepository extends JpaRepository<SlipEntity, Long> {
    SlipEntity findBySlipIdx(long slipIdx);
}
