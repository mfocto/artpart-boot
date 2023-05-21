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

import static org.ict.artpartM.member.entity.QMemberEntity.memberEntity;


@RequiredArgsConstructor
@Repository
public class MemberRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public Page<MemberEntity> findAllBySearchCondition(
            Pageable pageable, SearchCondition searchCondition){
        JPAQuery<MemberEntity> query = queryFactory.selectFrom(memberEntity)
                .where(searchKeywords(searchCondition.getSv() ,searchCondition.getSv1(),searchCondition.getSv2()));

        long total = query.stream().count();

        List<MemberEntity> results = query
                .where(searchKeywords(searchCondition.getSv() ,searchCondition.getSv1(),searchCondition.getSv2() ))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(memberEntity.memberidx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }
    public long membercount(){
        JPAQuery<MemberEntity> query = queryFactory.selectFrom(memberEntity)
                .where(loginok());
        long total = query.stream().count();
        return total;
    }

    public BooleanExpression loginok(){
        return memberEntity.memberloginok.contains("Y");
    }

    private BooleanExpression searchKeywords(String sv , String sv1 , String sv2){

            if(StringUtils.hasLength(sv)&&StringUtils.hasLength(sv1)&&StringUtils.hasLength(sv2)){
                return memberEntity.memberdong.contains(sv).and(memberEntity.memberho.contains(sv1).and(memberEntity.membername.contains(sv2)));
            }
            else if(StringUtils.hasLength(sv)&&StringUtils.hasLength(sv1)&&!(StringUtils.hasLength(sv2))){
                return memberEntity.memberdong.contains(sv).and(memberEntity.memberho.contains(sv1));
            }

            else if(StringUtils.hasLength(sv)&&!(StringUtils.hasLength(sv1))&&StringUtils.hasLength(sv2)){
                return memberEntity.memberdong.contains(sv).and(memberEntity.membername.contains(sv2));
            }

            else if(!(StringUtils.hasLength(sv))&&StringUtils.hasLength(sv1)&&StringUtils.hasLength(sv2)){
                return memberEntity.memberho.contains(sv1).and(memberEntity.membername.contains(sv2));
            }

            else if(StringUtils.hasLength(sv)&&!(StringUtils.hasLength(sv1))&&!(StringUtils.hasLength(sv2))){
                return memberEntity.memberdong.contains(sv);
            }
            else if(!(StringUtils.hasLength(sv))&&StringUtils.hasLength(sv1)&&!(StringUtils.hasLength(sv2))){
                return memberEntity.memberho.contains(sv1);
            }
            else if(!(StringUtils.hasLength(sv))&&!(StringUtils.hasLength(sv1))&&StringUtils.hasLength(sv2)){
                return memberEntity.membername.contains(sv2);
            }

            return null;


    }
}
