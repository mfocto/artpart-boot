package org.ict.artpartM.read.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.member.entity.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.ict.artpartM.member.entity.QMemberEntity.memberEntity;
import static org.ict.artpartM.read.entity.QReadEntity.readEntity;

@RequiredArgsConstructor
@Repository
public class ReadRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public Page<ReadEntity> findAllBySearchCondition(
            Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<ReadEntity> query = queryFactory.selectFrom(readEntity)
                .join(readEntity.memberidx, memberEntity)
                .where(searchKeywords(searchCondition.getSv()));

        long total = query.stream().count();
        List<ReadEntity> results = query
                .where(searchKeywords(searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(memberEntity.memberdong.asc(), memberEntity.memberho.asc())
                .fetch();
        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression searchKeywords(String sv) {
            if (StringUtils.hasLength(sv)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
                YearMonth searchMonth = YearMonth.parse(sv, formatter);
                LocalDateTime startOfMonth = searchMonth.atDay(1).atStartOfDay();
                LocalDateTime startOfNextMonth = searchMonth.plusMonths(1).atDay(1).atStartOfDay();
                return readEntity.readdate.between(startOfMonth, startOfNextMonth);
            }



        return null;

    }
    public ReadEntity findByMemberidxAndReaddate(MemberEntity memberidx, LocalDateTime readdate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        YearMonth searchMonth = YearMonth.from(readdate);
        LocalDateTime startOfMonth = searchMonth.atDay(1).atStartOfDay();
        LocalDateTime startOfNextMonth = searchMonth.plusMonths(1).atDay(1).atStartOfDay();
        return queryFactory.selectFrom(readEntity)
                .where(readEntity.memberidx.eq(memberidx)
                        .and(readEntity.readdate.between(startOfMonth, startOfNextMonth)))
                .fetchOne();
    }
}