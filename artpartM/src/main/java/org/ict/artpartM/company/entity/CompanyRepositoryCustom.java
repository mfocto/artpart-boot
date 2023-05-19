package org.ict.artpartM.company.entity;

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

import static org.ict.artpartM.company.entity.QCompanyEntity.companyEntity;

@RequiredArgsConstructor
@Repository
public class CompanyRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public Page<CompanyEntity> findAllBySearchCondition(
            Pageable pageable, SearchCondition searchCondition){
        JPAQuery<CompanyEntity> query = queryFactory.selectFrom(companyEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();

        List<CompanyEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(companyEntity.companyidx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }
    private BooleanExpression searchKeywords(String sk, String sv){
        if("name".equals(sk)){
            if(StringUtils.hasLength(sv)){
                return companyEntity.name.contains(sv);
            }
        }else if("item".equals(sk)){
            if(StringUtils.hasLength(sv)){
                return companyEntity.item.contains(sv);
            }
        }

        return null;
    }
}
