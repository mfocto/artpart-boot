package org.ict.artpart.paymentmember.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface PaymentMemberRepository extends JpaRepository<PaymentMemberEntity, Long> {
}
