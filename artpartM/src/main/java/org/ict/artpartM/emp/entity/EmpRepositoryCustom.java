package org.ict.artpartM.emp.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.ict.artpartM.common.SearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.ict.artpartM.emp.entity.QEmpEntity.empEntity;
@RequiredArgsConstructor
@Repository
public class EmpRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public Page<EmpEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<EmpEntity> query = queryFactory.selectFrom(empEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();

        List<EmpEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(empEntity.empIdx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression searchKeywords(String sk, String sv) {
        if ("emp_name".equals(sk)) {
            if (StringUtils.hasLength(sv)) {
                return empEntity.empName.contains(sv);
            }
        } else if ("emp_departmentid".equals(sk)) {
            if (StringUtils.hasLength(sv)) {
                return empEntity.empDepartmentId.contains(sv);
            }
        } else if ("emp_jobid".equals(sk)) {
            if (StringUtils.hasLength(sv)) {
                return empEntity.empJobId.contains(sv);
            }
        } else if ("emp_partmentid".equals(sk)) {
            if (StringUtils.hasLength(sv)) {
                return empEntity.empPermanentId.contains(sv);
            }
        } else if ("emp_hiredate".equals(sk)) {
            if (StringUtils.hasLength(sv)) {
                return empEntity.empHireDate.notIn(LocalDate.parse(sv));
            }
        }
        return null;
    }
}
