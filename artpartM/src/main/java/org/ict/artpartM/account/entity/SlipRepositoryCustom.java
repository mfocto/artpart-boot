package org.ict.artpartM.account.entity;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.ict.artpartM.common.SearchCondition;
import org.springframework.stereotype.Repository;
import static org.ict.artpartM.account.entity.QSlipEntity.slipEntity;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SlipRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public List<SlipEntity> findAllBySearchCondition(SearchCondition searchCondition) {
        JPAQuery<SlipEntity> query = queryFactory.selectFrom(slipEntity);

        if(searchCondition.getSv() != null && searchCondition.getSv().length() > 0) {
        query.where(slipEntity.slipNo.contains(searchCondition.getSv()));
        }
        return query
                .orderBy(slipEntity.slipIdx.desc())
                .fetch();
    }
}
