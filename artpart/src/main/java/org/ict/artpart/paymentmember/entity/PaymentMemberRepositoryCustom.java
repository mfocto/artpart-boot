package org.ict.artpart.paymentmember.entity;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.ict.artpart.common.SumByYear;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.ict.artpart.paymentmember.entity.QPaymentMemberEntity.paymentMemberEntity;

@Repository
@RequiredArgsConstructor
public class PaymentMemberRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final EntityManager entityManager;
    private Tuple tuple;

    public List<PaymentMemberEntity> findAllByMonth() {
        LocalDate now = LocalDate.now();
        // CriteriaBuilder 생성
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // CriteriaQuery 생성
        CriteriaQuery<PaymentMemberEntity> criteriaQuery = criteriaBuilder.createQuery(PaymentMemberEntity.class);
        Root<PaymentMemberEntity> root = criteriaQuery.from(PaymentMemberEntity.class);

        // 현재 년도 가져오기
        int currentYear = LocalDate.now().getYear();

        // 비교를 위한 표현식 생성
        Expression<Integer> dbYear = criteriaBuilder.function("YEAR", Integer.class, root.get("pmDate"));

        // 비교 조건 생성
        Predicate yearPredicate = criteriaBuilder.equal(dbYear, currentYear);

        // 쿼리에 조건 추가
        criteriaQuery.select(root).where(yearPredicate);

        // EntityManager를 사용하여 쿼리 실행
        List<PaymentMemberEntity> monthList = entityManager.createQuery(criteriaQuery).getResultList();
        return monthList;
    }

    public List<SumByYear> findSumByYear() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SumByYear> criteriaQuery = criteriaBuilder.createQuery(SumByYear.class);
        Root<PaymentMemberEntity> root = criteriaQuery.from(PaymentMemberEntity.class);

        Expression<Long> dbYear = criteriaBuilder.function("YEAR", Long.class, root.get("pmDate"));
        Expression<Long> sumExpression = criteriaBuilder.sum(
                criteriaBuilder.sum(
                        criteriaBuilder.sum(
                                criteriaBuilder.sum(
                                        criteriaBuilder.sum(
                                                criteriaBuilder.sum(
                                                        criteriaBuilder.sum(
                                                                criteriaBuilder.sum(
                                                                        criteriaBuilder.sum(
                                                                                root.get("pmHeat"),
                                                                                root.get("pmOnsu")
                                                                        ),
                                                                        root.get("pmGas")
                                                                ),
                                                                root.get("pmElec")
                                                        ),
                                                        root.get("pmWater")
                                                ),
                                                root.get("pmSeptic")
                                        ),
                                        root.get("pmWaste")
                                ),
                                root.get("pmOpercost")
                        ),
                        root.get("pmInsure")
                )
        );

        criteriaQuery.select(criteriaBuilder.construct(SumByYear.class, dbYear, sumExpression));
        criteriaQuery.groupBy(dbYear);

        List<SumByYear> result = entityManager.createQuery(criteriaQuery).getResultList();

        return result;
    }

    //년도별
//    public List<SumByYear> findSumByYear() {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
//        Root<PaymentMemberEntity> root = criteriaQuery.from(PaymentMemberEntity.class);
//
//        Expression<Integer> dbYear = criteriaBuilder.function("YEAR", Integer.class, root.get("pmDate"));
//        Expression<Long> sumExpression = criteriaBuilder.sum(
//                criteriaBuilder.sum(
//                        criteriaBuilder.sum(
//                                criteriaBuilder.sum(
//                                        criteriaBuilder.sum(
//                                                criteriaBuilder.sum(
//                                                        criteriaBuilder.sum(
//                                                                criteriaBuilder.sum(
//                                                                        criteriaBuilder.sum(
//                                                                                root.get("pmHeat"),
//                                                                                root.get("pmOnsu")
//                                                                        ),
//                                                                        root.get("pmGas")
//                                                                ),
//                                                                root.get("pmElec")
//                                                        ),
//                                                        root.get("pmWater")
//                                                ),
//                                                root.get("pmSeptic")
//                                        ),
//                                        root.get("pmWaste")
//                                ),
//                                root.get("pmOpercost")
//                        ),
//                        root.get("pmInsure")
//                )
//        );
//
//        criteriaQuery.multiselect(dbYear, sumExpression);
//        criteriaQuery.groupBy(dbYear);
//
//        List<Tuple> resultList = entityManager.createQuery(criteriaQuery).getResultList();
//
//        List<SumByYear> result = new ArrayList<>();
//        for (Tuple tuple : resultList) {
//            Integer year = tuple.get((com.querydsl.core.types.Expression<Integer>) dbYear);
//            Long sum = tuple.get((com.querydsl.core.types.Expression<Long>) sumExpression);
//            result.add(new SumByYear(year, sum));
//        }
//
//        return result;
//
//    }
    //컬럼별 합계 구하는 메소드

}
