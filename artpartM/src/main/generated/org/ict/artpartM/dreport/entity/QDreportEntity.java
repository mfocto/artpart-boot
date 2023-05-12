package org.ict.artpartM.dreport.entity;

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

    private static final long serialVersionUID = -1704309569L;

    public static final QDreportEntity dreportEntity = new QDreportEntity("dreportEntity");

    public final StringPath trialDailyAccount = createString("trialDailyAccount");

    public final NumberPath<Long> trialDailyCreditIn = createNumber("trialDailyCreditIn", Long.class);

    public final NumberPath<Long> trialDailyCreditOut = createNumber("trialDailyCreditOut", Long.class);

    public final NumberPath<Long> trialDailyCreditTotal = createNumber("trialDailyCreditTotal", Long.class);

    public final DateTimePath<java.time.LocalDateTime> trialDailyDate = createDateTime("trialDailyDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> trialDailyDebitIn = createNumber("trialDailyDebitIn", Long.class);

    public final NumberPath<Long> trialDailyDebitOut = createNumber("trialDailyDebitOut", Long.class);

    public final NumberPath<Long> trialDailyDebitTotal = createNumber("trialDailyDebitTotal", Long.class);

    public final NumberPath<Long> trialDailyIdx = createNumber("trialDailyIdx", Long.class);

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

