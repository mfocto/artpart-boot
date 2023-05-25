package org.ict.artpart.paymentmember.entity;

import org.ict.artpart.paymentmember.model.dto.PaymentMemberDto;
import org.ict.artpart.paymentmember.model.dto.PaymentSumDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PaymentMemberRepository extends JpaRepository<PaymentMemberEntity, Long> {
    @Query(value = " SELECT EXTRACT(YEAR FROM PMDATE) as PMDATE, " +
            " SUM(PMHEAT) as PMHEAT, " +
            " SUM(PMONSU) as PMONSU, " +
            " SUM(PMGAS) as PMGAS, " +
            " SUM(PMELEC) as PMELEC, " +
            " SUM(PMWATER) as PMWATER, " +
            " SUM(PMSEPTIC) as PMSEPTIC, " +
            " SUM(PMWASTE) as PMWASTE, " +
            " SUM(PMOPERCOST) as PMOPERCOST, " +
            " SUM(PMINSURE) as PMINSURE" +
            " FROM PAYMENT_MEMBER " +
            " GROUP BY EXTRACT(YEAR FROM PMDATE)" +
            " ORDER BY PMDATE ASC", nativeQuery = true)
    List<Object[]> getPmSumByYear();

    @Query(value = "SELECT PMDATE, (PMHEAT + PMONSU + PMGAS + PMELEC + PMWATER + PMSEPTIC + PMWASTE + PMOPERCOST + PMINSURE) AS PMHEAT FROM PAYMENT_MEMBER ORDER BY PMDATE DESC", nativeQuery = true)
    List<Object[]> getPmSixMonth();
}

