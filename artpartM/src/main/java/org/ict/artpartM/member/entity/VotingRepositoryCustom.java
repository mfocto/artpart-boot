package org.ict.artpartM.member.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.ict.artpartM.common.SearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

import static org.ict.artpartM.member.entity.QVotingEntity.votingEntity;


@RequiredArgsConstructor
@Repository
public class VotingRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public Page<VotingEntity> findAllBySearchCondition(
            Pageable pageable, SearchCondition searchCondition){
        JPAQuery<VotingEntity> query = queryFactory.selectFrom(votingEntity)
                .where(searchKeywords(searchCondition.getSv() ,searchCondition.getSv1()));

        long total = query.stream().count();

        List<VotingEntity> results = query
                .where(searchKeywords(searchCondition.getSv() ,searchCondition.getSv1()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(votingEntity.votingidx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression searchKeywords(String sv , String sv1 ){

        if(StringUtils.hasLength(sv)&&StringUtils.hasLength(sv1)){
            return votingEntity.endtime.eq(LocalDate.parse(sv)).and(votingEntity.votingstart.contains(sv1));
        }
        else if(StringUtils.hasLength(sv)&&!(StringUtils.hasLength(sv1))) {
            return votingEntity.endtime.eq(LocalDate.parse(sv));
        }
        else if(!(StringUtils.hasLength(sv))&&StringUtils.hasLength(sv1)) {
            return votingEntity.votingstart.contains(sv1);
        }

        return null;


    }
}
