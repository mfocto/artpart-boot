package org.ict.artpart.paymentmember.entity;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.ict.artpart.paymentmember.entity.QPaymentMemberEntity.paymentMemberEntity;

@Repository
@RequiredArgsConstructor
public class PaymentMemberRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final EntityManager entityManager;
    public List<PaymentMemberEntity> findAllByMonth(){
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


    public Map<Integer, Integer> findSumByYear() {
        // CriteriaBuilder 생성
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // CriteriaQuery 생성
        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        Root<PaymentMemberEntity> root = criteriaQuery.from(PaymentMemberEntity.class);

        // 연도별 합계 계산을 위한 표현식 생성
        Expression<Integer> dbYear = criteriaBuilder.function("YEAR", Integer.class, root.get("pmDate"));
        Expression<Integer> sumExpression = criteriaBuilder.sum(root.get("pmAmount"));

        // 연도별 합계를 위한 그룹화 설정
        criteriaQuery.multiselect(dbYear, sumExpression);
        criteriaQuery.groupBy(dbYear);

        // EntityManager를 사용하여 쿼리 실행
        List<Tuple> result = entityManager.createQuery(criteriaQuery).getResultList();

        // 결과를 Map으로 변환
        Map<Integer, Integer> sumByYear = new HashMap<>();
        for (Tuple tuple : result) {
            Integer year = tuple.get(0, Integer.class);
            Integer sum = tuple.get(1, Integer.class);
            sumByYear.put(year, sum);
        }

        return sumByYear;
    }
}
