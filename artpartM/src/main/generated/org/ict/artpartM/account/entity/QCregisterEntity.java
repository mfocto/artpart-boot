package org.ict.artpartM.account.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCregisterEntity is a Querydsl query type for CregisterEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCregisterEntity extends EntityPathBase<CregisterEntity> {

    private static final long serialVersionUID = 1918722936L;

    public static final QCregisterEntity cregisterEntity = new QCregisterEntity("cregisterEntity");

    public final StringPath crBrif = createString("crBrif");

    public final NumberPath<Long> crCash = createNumber("crCash", Long.class);

    public final DatePath<java.time.LocalDate> crDate = createDate("crDate", java.time.LocalDate.class);

    public final NumberPath<Long> crIdx = createNumber("crIdx", Long.class);

    public final NumberPath<Long> crIn = createNumber("crIn", Long.class);

    public final StringPath crNote = createString("crNote");

    public final NumberPath<Long> crOut = createNumber("crOut", Long.class);

    public final StringPath crWriter = createString("crWriter");

    public QCregisterEntity(String variable) {
        super(CregisterEntity.class, forVariable(variable));
    }

    public QCregisterEntity(Path<? extends CregisterEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCregisterEntity(PathMetadata metadata) {
        super(CregisterEntity.class, metadata);
    }

}

