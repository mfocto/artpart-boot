package org.ict.artpart.using.entity;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.ict.artpart.using.entity.QUsingEntity.usingEntity;

@Repository
@RequiredArgsConstructor
public class UsingRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public Page<UsingEntity> findAll(Pageable pageable){
        JPAQuery<UsingEntity> query = queryFactory.selectFrom(usingEntity);

        long total = query.stream().count();

        List<UsingEntity> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(usingEntity.paymentDadLine.desc())
                .fetch();
        return new PageImpl<>(results, pageable, total);
    }

}
