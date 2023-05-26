package org.ict.artpartM.account.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.ict.artpartM.common.SearchCondition;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.ict.artpartM.account.entity.QPaymentMemberEntity.paymentMemberEntity;

@RequiredArgsConstructor
@Repository
public class PaymentRepositotyCustom {

    private final JPAQueryFactory queryFactory;

    public List<PaymentMemberEntity> findAllBySearchCondition(SearchCondition searchCondition) {
        JPAQuery<PaymentMemberEntity> query = queryFactory.selectFrom(paymentMemberEntity)
                .where(dateSearch(searchCondition.getSv()))
                .where(searchDong(searchCondition.getSv1()))
                .where(searchHo(searchCondition.getSv2()));

        return query
                .where(dateSearch(searchCondition.getSv()))
                .where(searchDong(searchCondition.getSv1()))
                .where(searchHo(searchCondition.getSv2()))
                .orderBy(paymentMemberEntity.PMDate.desc())
                .fetch();
    }

    private BooleanExpression searchDong(String sv1) {
        if (StringUtils.hasLength(sv1)) {
            return paymentMemberEntity.memberNo.memberdong.contains(sv1);
        }
        return null;
    }

    private BooleanExpression searchHo(String sv2) {
        if (StringUtils.hasLength(sv2)) {
            return paymentMemberEntity.memberNo.memberho.contains(sv2);
        }
        return null;
    }


    private BooleanExpression dateSearch(String sv) {
        if (StringUtils.hasLength(sv)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate time = LocalDate.parse(sv+"-01", formatter);
            return paymentMemberEntity.PMDate.eq(time)
                    .or(paymentMemberEntity.PMDate.before(time));
        }
        return null;
    }
}
