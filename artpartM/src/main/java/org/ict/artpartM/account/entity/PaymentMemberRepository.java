package org.ict.artpartM.account.entity;

import org.ict.artpartM.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PaymentMemberRepository extends JpaRepository<PaymentMemberEntity, Long> {

    PaymentMemberEntity findByMemberNoAndPMDate(MemberEntity byMemberdongAndMemberho, LocalDate parse);
}
