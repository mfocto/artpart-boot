package org.ict.artpart.minone.model.entity;


import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.ict.artpart.common.SearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;



@RequiredArgsConstructor
@Repository
public class MinoneRepositoryCustom {
    private final JPAQueryFactory queryFactory;

//    public Page<MinoneEntity> findAllBySearchCondition(
//            Pageable pageable, SearchCondition searchCondition){
//        JPAQuery<MinoneEntity> query = queryFactory.selectFrom(minoneEntity)
//                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));
//
//        long total = query.stream().count();
//
//        List<MinoneEntity> results = query
//                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .orderBy(minoneEntity.minoneidx.desc())
//                .fetch();
//
//        return new PageImpl<>(results, pageable, total);
//    }

//    private BooleanExpression searchKeywords(String sk, String sv){
//        if("minidx".equals(sk)){
//            if(StringUtils.hasLength(sv)){
//                return minoneEntity.writer.empName.contains(sv);
//            }
//        } else if ("mintitle".equals(sk)) {
//            if(StringUtils.hasLength(sv)){
//                return minoneEntity.title.contains(sv);
//            }
//        } else if ("minstatus".equals(sk)) {
//            if(StringUtils.hasLength(sv)){
//                return minoneEntity.content.contains(sv);
//            }
//        }
//
//        return null;
//    }

}
