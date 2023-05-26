package org.ict.artpartM.account.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PaymentPublicRepository extends JpaRepository<PaymentPublicEntity, Long> {

    PaymentPublicEntity findByPPDate(LocalDate pmDate);
}
