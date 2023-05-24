package org.ict.artpart.paymentmember.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPaymentMemberEntity is a Querydsl query type for PaymentMemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPaymentMemberEntity extends EntityPathBase<PaymentMemberEntity> {

    private static final long serialVersionUID = 1575029724L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPaymentMemberEntity paymentMemberEntity = new QPaymentMemberEntity("paymentMemberEntity");

    public final org.ict.artpart.member.entity.QMemberEntity memberNo;

    public final DateTimePath<java.util.Date> pmDate = createDateTime("pmDate", java.util.Date.class);

    public final NumberPath<java.math.BigDecimal> pmElec = createNumber("pmElec", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> pmGas = createNumber("pmGas", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> pmHeat = createNumber("pmHeat", java.math.BigDecimal.class);

    public final NumberPath<Long> pmIdx = createNumber("pmIdx", Long.class);

    public final NumberPath<java.math.BigDecimal> pmInsure = createNumber("pmInsure", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> pmOnsu = createNumber("pmOnsu", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> pmOpercost = createNumber("pmOpercost", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> pmSeptic = createNumber("pmSeptic", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> pmWaste = createNumber("pmWaste", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> pmWater = createNumber("pmWater", java.math.BigDecimal.class);

    public QPaymentMemberEntity(String variable) {
        this(PaymentMemberEntity.class, forVariable(variable), INITS);
    }

    public QPaymentMemberEntity(Path<? extends PaymentMemberEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPaymentMemberEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPaymentMemberEntity(PathMetadata metadata, PathInits inits) {
        this(PaymentMemberEntity.class, metadata, inits);
    }

    public QPaymentMemberEntity(Class<? extends PaymentMemberEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberNo = inits.isInitialized("memberNo") ? new org.ict.artpart.member.entity.QMemberEntity(forProperty("memberNo"), inits.get("memberNo")) : null;
    }

}

