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

import static org.ict.artpartM.account.entity.QDreportEntity.dreportEntity;

@RequiredArgsConstructor
@Repository
public class DreportRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public List<DreportEntity> findAllBySearchCondition(SearchCondition searchCondition) {
        JPAQuery<DreportEntity> query = queryFactory.selectFrom(dreportEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        return query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .orderBy(dreportEntity.TDDate.desc())
                .fetch();
    }

    private BooleanExpression searchKeywords(String sk, String sv) {
        if (sk.equals("tdaccount")) {
            if (StringUtils.hasLength(sv)) {
                return dreportEntity.TDAccount.contains(sv);
            }
        } else if (sk.equals("tdidx")) {
            if (StringUtils.hasLength(sv)) {
                long svLong = Long.parseLong(sv);
                return dreportEntity.TDIdx.eq(svLong);
            }
            return null;
        } else if(sk.equals("tddate")) {
            if (StringUtils.hasLength(sv)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate time = LocalDate.parse(sv, formatter);
                return dreportEntity.TDDate.eq(time)
                        .or(dreportEntity.TDDate.before(time));
            }
        }
        return null;
    }
}
