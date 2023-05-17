package org.ict.artpart.notice.entity;

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

import static org.ict.artpart.notice.entity.QNoticeEntity.noticeEntity;

@Repository
@RequiredArgsConstructor
public class NoticeRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    //조회
    public Page<NoticeEntity> findAllBySearchCondition
            (Pageable pageable, SearchCondition searchCondition) {

        JPAQuery<NoticeEntity> query = jpaQueryFactory.selectFrom(noticeEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();

        List<NoticeEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(noticeEntity.noticeIdx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    //검색 기능
    private BooleanExpression searchKeywords(String sk, String sv){
        if("notice_writer".equals(sk)){
            if(StringUtils.hasLength(sv)){
                return noticeEntity.writer.empName.contains(sv);
            }
        } else if ("notice_title".equals(sk)) {
            if(StringUtils.hasLength(sv)){
                return noticeEntity.title.contains(sv);
            }
        } else if ("notice_content".equals(sk)) {
            if(StringUtils.hasLength(sv)){
                return noticeEntity.content.contains(sv);
            }
        }

        return null;
    }
}
