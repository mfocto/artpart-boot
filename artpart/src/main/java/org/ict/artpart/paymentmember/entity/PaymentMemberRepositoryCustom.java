package org.ict.artpart.paymentmember.entity;

import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.List;



@Repository
@RequiredArgsConstructor
public class PaymentMemberRepositoryCustom {
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


}
