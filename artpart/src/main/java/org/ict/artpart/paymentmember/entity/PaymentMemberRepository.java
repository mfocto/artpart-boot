package org.ict.artpart.paymentmember.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PaymentMemberRepository extends JpaRepository<PaymentMemberEntity, Long> {
    //연도별 평균
    @Query(value = " SELECT EXTRACT(YEAR FROM PMDATE) as PMDATE, " +
            " AVG(PMHEAT) as PMHEAT, " +
            " AVG(PMONSU) as PMONSU, " +
            " AVG(PMGAS) as PMGAS, " +
            " AVG(PMELEC) as PMELEC, " +
            " AVG(PMWATER) as PMWATER, " +
            " AVG(PMSEPTIC) as PMSEPTIC, " +
            " AVG(PMWASTE) as PMWASTE, " +
            " AVG(PMOPERCOST) as PMOPERCOST, " +
            " AVG(PMINSURE) as PMINSURE" +
            " FROM PAYMENT_MEMBER " +
            " GROUP BY EXTRACT(YEAR FROM PMDATE)" +
            " ORDER BY PMDATE DESC", nativeQuery = true)
    List<Object[]> findByPmSumByYear();

    //최근 6개월 차트용
    @Query(value = "SELECT * FROM " +
            "(SELECT PMDATE, (PMHEAT + PMONSU + PMGAS + PMELEC + PMWATER + PMSEPTIC + PMWASTE + PMOPERCOST + PMINSURE) AS PMHEAT, " +
            "ROW_NUMBER() OVER (ORDER BY PMDATE DESC) AS rn " +
            "FROM PAYMENT_MEMBER) " +
            "WHERE rn <= 6" +
            "ORDER BY rn desc", nativeQuery = true)
    List<Object[]> findByPmSixMonth();

    //이번달 관리비
    @Query(value = "SELECT * FROM " +
            "(SELECT PMDATE, PMHEAT, PMONSU, PMGAS, PMELEC, PMWATER, PMSEPTIC, PMWASTE, PMOPERCOST, PMINSURE, " +
            "ROW_NUMBER() OVER (ORDER BY PMDATE DESC) AS rn " +
            "FROM PAYMENT_MEMBER) " +
            "WHERE rn <= 2" , nativeQuery = true)
    List<Object[]> findByPmMonth();
}

