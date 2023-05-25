package org.ict.artpartM.car.entity;

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

import static org.ict.artpartM.car.entity.QCarEntity.carEntity;
@RequiredArgsConstructor
@Repository
public class CarRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public Page<CarEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<CarEntity> query = queryFactory.selectFrom(carEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();

        List<CarEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(carEntity.carIdx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression searchKeywords(String sk, String sv) {
        if ("car_mumber".equals(sk)) {
            if (StringUtils.hasLength(sv)) {
                return carEntity.carNumber.contains(sv);
            }
        } else if ("car_division_id".equals(sk)) {
            if (StringUtils.hasLength(sv)) {
                return carEntity.carDivisionId.contains(sv);
            }
        } else if("member_memberdong".equals(sk)){
            if (StringUtils.hasLength(sv)){
                return carEntity.memberCarid.memberdong.contains(sv);
            }
        } else if("member_memberho".equals(sk)){
            if(StringUtils.hasLength(sv)){
                return carEntity.memberCarid.memberho.contains(sv);
            }
        }else if("emp_name".equals(sk)){
            if (StringUtils.hasLength(sv)){
               return carEntity.empCarid.empName.contains(sv);
            }
        }
        return null;
    }

}
