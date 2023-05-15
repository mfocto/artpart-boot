package org.ict.artpartM.account.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSlipEntity is a Querydsl query type for SlipEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSlipEntity extends EntityPathBase<SlipEntity> {

    private static final long serialVersionUID = -16860172L;

    public static final QSlipEntity slipEntity = new QSlipEntity("slipEntity");

    public final StringPath slipBrif = createString("slipBrif");

    public final NumberPath<Long> slipCash = createNumber("slipCash", Long.class);

    public final StringPath slipComp = createString("slipComp");

    public final DatePath<java.time.LocalDate> slipDate = createDate("slipDate", java.time.LocalDate.class);

    public final NumberPath<Long> slipIdx = createNumber("slipIdx", Long.class);

    public final StringPath slipItem = createString("slipItem");

    public final StringPath slipNo = createString("slipNo");

    public final StringPath slipNote = createString("slipNote");

    public final StringPath slipType = createString("slipType");

    public QSlipEntity(String variable) {
        super(SlipEntity.class, forVariable(variable));
    }

    public QSlipEntity(Path<? extends SlipEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSlipEntity(PathMetadata metadata) {
        super(SlipEntity.class, metadata);
    }

}

