package org.ict.artpartM.member.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.notice.entity.NoticeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static org.ict.artpartM.member.entity.QMemberEntity.memberEntity;


@RequiredArgsConstructor
@Repository
public class MemberRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public Page<MemberEntity> findAllBySearchCondition(
            Pageable pageable, SearchCondition searchCondition){
        JPAQuery<MemberEntity> query = queryFactory.selectFrom(memberEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();

        List<MemberEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(memberEntity.memberidx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression searchKeywords(String sk, String sv){
        if("member_name".equals(sk)){
            if(StringUtils.hasLength(sv)){
                return memberEntity.membername.contains(sv);
            }
        } else if ("member_dong".equals(sk)) {
            if(StringUtils.hasLength(sv)){
                return memberEntity.memberdong.contains(sv);
            }
        } else if ("member_ho".equals(sk)) {
            if(StringUtils.hasLength(sv)){
                return memberEntity.memberho.contains(sv);
            }
        }

        return null;
    }
}