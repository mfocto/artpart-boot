package org.ict.artpartM.company.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCompanyEntity is a Querydsl query type for CompanyEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCompanyEntity extends EntityPathBase<CompanyEntity> {

    private static final long serialVersionUID = -1426383329L;

    public static final QCompanyEntity companyEntity = new QCompanyEntity("companyEntity");

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> companydate = createDate("companydate", java.time.LocalDate.class);

    public final NumberPath<Long> companyidx = createNumber("companyidx", Long.class);

    public final StringPath item = createString("item");

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public QCompanyEntity(String variable) {
        super(CompanyEntity.class, forVariable(variable));
    }

    public QCompanyEntity(Path<? extends CompanyEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCompanyEntity(PathMetadata metadata) {
        super(CompanyEntity.class, metadata);
    }

}

