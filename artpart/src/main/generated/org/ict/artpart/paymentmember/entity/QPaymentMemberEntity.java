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

    public final DatePath<java.sql.Date> pmDate = createDate("pmDate", java.sql.Date.class);

    public final NumberPath<Integer> pmElec = createNumber("pmElec", Integer.class);

    public final NumberPath<Integer> pmGas = createNumber("pmGas", Integer.class);

    public final NumberPath<Integer> pmHeat = createNumber("pmHeat", Integer.class);

    public final NumberPath<Long> pmIdx = createNumber("pmIdx", Long.class);

    public final NumberPath<Integer> pmInsure = createNumber("pmInsure", Integer.class);

    public final NumberPath<Integer> pmOnsu = createNumber("pmOnsu", Integer.class);

    public final NumberPath<Integer> pmOpercost = createNumber("pmOpercost", Integer.class);

    public final NumberPath<Integer> pmSeptic = createNumber("pmSeptic", Integer.class);

    public final NumberPath<Integer> pmWaste = createNumber("pmWaste", Integer.class);

    public final NumberPath<Integer> pmWater = createNumber("pmWater", Integer.class);

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

