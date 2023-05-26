package org.ict.artpartM.seesul.entity;

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

import static org.ict.artpartM.seesul.entity.QSeesulEntity.seesulEntity;

@RequiredArgsConstructor
@Repository
public class SeesulRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public Page<SeesulEntity> findAllBySearchCondition(
            Pageable pageable, SearchCondition searchCondition){
        JPAQuery<SeesulEntity> query = queryFactory.selectFrom(seesulEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();

        List<SeesulEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(seesulEntity.sdate.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }
    private BooleanExpression searchKeywords(String sk, String sv){
      if("scategory".equals(sk)){
        if(StringUtils.hasLength(sv)){
            return  seesulEntity.scategory.contains(sv);
        }
      }
        return null;
    }
}
