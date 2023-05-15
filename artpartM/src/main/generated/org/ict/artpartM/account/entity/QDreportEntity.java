package org.ict.artpartM.account.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDreportEntity is a Querydsl query type for DreportEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDreportEntity extends EntityPathBase<DreportEntity> {

    private static final long serialVersionUID = -1550369718L;

    public static final QDreportEntity dreportEntity = new QDreportEntity("dreportEntity");

    public final StringPath TDAccount = createString("TDAccount");

    public final NumberPath<Long> TDCreditIn = createNumber("TDCreditIn", Long.class);

    public final NumberPath<Long> TDCreditOut = createNumber("TDCreditOut", Long.class);

    public final NumberPath<Long> TDCreditTotal = createNumber("TDCreditTotal", Long.class);

    public final DatePath<java.time.LocalDate> TDDate = createDate("TDDate", java.time.LocalDate.class);

    public final NumberPath<Long> TDDebitIn = createNumber("TDDebitIn", Long.class);

    public final NumberPath<Long> TDDebitOut = createNumber("TDDebitOut", Long.class);

    public final NumberPath<Long> TDDebitTotal = createNumber("TDDebitTotal", Long.class);

    public final NumberPath<Long> TDIdx = createNumber("TDIdx", Long.class);

    public QDreportEntity(String variable) {
        super(DreportEntity.class, forVariable(variable));
    }

    public QDreportEntity(Path<? extends DreportEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDreportEntity(PathMetadata metadata) {
        super(DreportEntity.class, metadata);
    }

}

