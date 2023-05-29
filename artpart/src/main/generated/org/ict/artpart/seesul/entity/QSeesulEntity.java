package org.ict.artpart.seesul.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSeesulEntity is a Querydsl query type for SeesulEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSeesulEntity extends EntityPathBase<SeesulEntity> {

    private static final long serialVersionUID = 1968012036L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSeesulEntity seesulEntity = new QSeesulEntity("seesulEntity");

    public final StringPath scategory = createString("scategory");

    public final DatePath<java.time.LocalDate> sdate = createDate("sdate", java.time.LocalDate.class);

    public final NumberPath<Long> sidx = createNumber("sidx", Long.class);

    public final org.ict.artpart.emp.entity.QEmpEntity swiriter;

    public QSeesulEntity(String variable) {
        this(SeesulEntity.class, forVariable(variable), INITS);
    }

    public QSeesulEntity(Path<? extends SeesulEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSeesulEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSeesulEntity(PathMetadata metadata, PathInits inits) {
        this(SeesulEntity.class, metadata, inits);
    }

    public QSeesulEntity(Class<? extends SeesulEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.swiriter = inits.isInitialized("swiriter") ? new org.ict.artpart.emp.entity.QEmpEntity(forProperty("swiriter")) : null;
    }

}

