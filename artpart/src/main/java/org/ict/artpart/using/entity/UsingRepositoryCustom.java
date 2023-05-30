package org.ict.artpart.using.entity;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.ict.artpart.member.entity.QMemberEntity;
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

    public Page<UsingEntity> findAllUsing(Long id, Pageable pageable){
        JPAQuery<UsingEntity> query = queryFactory.selectFrom(usingEntity);

        QMemberEntity memberEntity = QMemberEntity.memberEntity;

        long total = query
                .join(usingEntity.memberIdx, memberEntity)
                .where(memberEntity.memberIdx.eq(id))
                .fetchCount();

        List<UsingEntity> results = query
                .join(usingEntity.memberIdx, memberEntity)
                .where(memberEntity.memberIdx.eq(id))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(usingEntity.detailIdx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }
}
