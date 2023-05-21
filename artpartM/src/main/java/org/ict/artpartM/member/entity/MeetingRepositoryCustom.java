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

import java.util.List;

import static org.ict.artpartM.member.entity.QMeetingEntity.meetingEntity;


@RequiredArgsConstructor
@Repository
public class MeetingRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public Page<MeetingEntity> findAllBySearchCondition(
            Pageable pageable, SearchCondition searchCondition){
        JPAQuery<MeetingEntity> query = queryFactory.selectFrom(meetingEntity)
                .where(searchKeywords(searchCondition.getSv() ,searchCondition.getSv1()));

        long total = query.stream().count();

        List<MeetingEntity> results = query
                .where(searchKeywords(searchCondition.getSv() ,searchCondition.getSv1()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(meetingEntity.meetingidx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression searchKeywords(String sv , String sv1 ){

        if(StringUtils.hasLength(sv)&&StringUtils.hasLength(sv1)){
            return meetingEntity.meetingtitle.contains(sv).and(meetingEntity.meetingopen.contains(sv1));
        }
        else if(StringUtils.hasLength(sv)&&!(StringUtils.hasLength(sv1))) {
            return meetingEntity.meetingtitle.contains(sv);
        }
        else if(!(StringUtils.hasLength(sv))&&StringUtils.hasLength(sv1)) {
            return meetingEntity.meetingopen.contains(sv1);
        }

        return null;


    }
}
