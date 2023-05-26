package org.ict.artpartM.account.entity;

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

    private static final long serialVersionUID = 79802546L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPaymentMemberEntity paymentMemberEntity = new QPaymentMemberEntity("paymentMemberEntity");

    public final org.ict.artpartM.member.entity.QMemberEntity memberNo;

    public final DatePath<java.time.LocalDate> PMDate = createDate("PMDate", java.time.LocalDate.class);

    public final NumberPath<Long> PMElec = createNumber("PMElec", Long.class);

    public final NumberPath<Long> PMGas = createNumber("PMGas", Long.class);

    public final NumberPath<Long> PMHeat = createNumber("PMHeat", Long.class);

    public final NumberPath<Long> PMIdx = createNumber("PMIdx", Long.class);

    public final NumberPath<Long> PMInsure = createNumber("PMInsure", Long.class);

    public final NumberPath<Long> PMOnsu = createNumber("PMOnsu", Long.class);

    public final NumberPath<Long> PMOpercost = createNumber("PMOpercost", Long.class);

    public final NumberPath<Long> PMSeptic = createNumber("PMSeptic", Long.class);

    public final NumberPath<Long> PMWaste = createNumber("PMWaste", Long.class);

    public final NumberPath<Long> PMWater = createNumber("PMWater", Long.class);

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
        this.memberNo = inits.isInitialized("memberNo") ? new org.ict.artpartM.member.entity.QMemberEntity(forProperty("memberNo"), inits.get("memberNo")) : null;
    }

}

