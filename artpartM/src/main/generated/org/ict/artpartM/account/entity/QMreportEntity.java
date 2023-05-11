package org.ict.artpartM.account.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMreportEntity is a Querydsl query type for MreportEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMreportEntity extends EntityPathBase<MreportEntity> {

    private static final long serialVersionUID = 103970515L;

    public static final QMreportEntity mreportEntity = new QMreportEntity("mreportEntity");

    public final StringPath TMAccount = createString("TMAccount");

    public final NumberPath<Long> TMCreditIn = createNumber("TMCreditIn", Long.class);

    public final NumberPath<Long> TMCreditOut = createNumber("TMCreditOut", Long.class);

    public final NumberPath<Long> TMCreditTotal = createNumber("TMCreditTotal", Long.class);

    public final DatePath<java.time.LocalDate> TMDate = createDate("TMDate", java.time.LocalDate.class);

    public final NumberPath<Long> TMDebitIn = createNumber("TMDebitIn", Long.class);

    public final NumberPath<Long> TMDebitOut = createNumber("TMDebitOut", Long.class);

    public final NumberPath<Long> TMDebitTotal = createNumber("TMDebitTotal", Long.class);

    public final NumberPath<Long> TMIdx = createNumber("TMIdx", Long.class);

    public QMreportEntity(String variable) {
        super(MreportEntity.class, forVariable(variable));
    }

    public QMreportEntity(Path<? extends MreportEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMreportEntity(PathMetadata metadata) {
        super(MreportEntity.class, metadata);
    }

}

