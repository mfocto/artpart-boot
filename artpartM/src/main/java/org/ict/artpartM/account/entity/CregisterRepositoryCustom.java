package org.ict.artpartM.account.entity;

import com.querydsl.core.QueryFactory;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.SearchCondition;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.ict.artpartM.account.entity.QCregisterEntity.cregisterEntity;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CregisterRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public List<CregisterEntity> findAllBySearchCondition(SearchCondition searchCondition) {
        log.info("searchCondition: {}", searchCondition);
        JPAQuery<CregisterEntity> query = queryFactory.selectFrom(cregisterEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));


        return query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .orderBy(cregisterEntity.crDate.desc())
                .fetch();
    }

    private BooleanExpression searchKeywords(String sk, String sv) {
        if (sk.equals("crbrif")) {
            if (StringUtils.hasLength(sv)) {
                return cregisterEntity.crBrif.contains(sv);
            }
        } else if (sk.equals("crwriter")) {
            if (StringUtils.hasLength(sv)) {
                return cregisterEntity.crWriter.contains(sv);
            }
        } else if (sk.equals("crdate")) {
            if (StringUtils.hasLength(sv)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate time = LocalDate.parse(sv, formatter);
                return cregisterEntity.crDate.eq(time)
                        .or(cregisterEntity.crDate.before(time));
            }
        }
        return null;
    }
}
