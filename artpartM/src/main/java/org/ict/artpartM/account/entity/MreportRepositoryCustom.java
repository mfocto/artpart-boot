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

import static org.ict.artpartM.account.entity.QMreportEntity.mreportEntity;

@RequiredArgsConstructor
@Repository
public class MreportRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public List<MreportEntity> findAllBySearchCondition(SearchCondition searchCondition) {
        JPAQuery<MreportEntity> query = queryFactory.selectFrom(mreportEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        return query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .orderBy(mreportEntity.TMDate.desc())
                .fetch();
    }

    private BooleanExpression searchKeywords(String sk, String sv) {
        if (sk.equals("tmaccount")) {
            if (StringUtils.hasLength(sv)) {
                return mreportEntity.TMAccount.contains(sv);
            }
        } else if (sk.equals("tmidx")) {
            if (StringUtils.hasLength(sv)) {
                long svLong = Long.parseLong(sv);
                return mreportEntity.TMIdx.eq(svLong);
            }
            return null;
        } else if(sk.equals("tmdate")) {
            if (StringUtils.hasLength(sv)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate time = LocalDate.parse(sv, formatter);
                return mreportEntity.TMDate.eq(time)
                        .or(mreportEntity.TMDate.before(time));
            }
        }
        return null;
    }
}
