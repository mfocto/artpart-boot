package org.ict.artpartM.account.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPaymentPublicEntity is a Querydsl query type for PaymentPublicEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPaymentPublicEntity extends EntityPathBase<PaymentPublicEntity> {

    private static final long serialVersionUID = 1001226561L;

    public static final QPaymentPublicEntity paymentPublicEntity = new QPaymentPublicEntity("paymentPublicEntity");

    public final DatePath<java.time.LocalDate> PPDate = createDate("PPDate", java.time.LocalDate.class);

    public final NumberPath<Long> PPFee = createNumber("PPFee", Long.class);

    public final NumberPath<Long> PPIdx = createNumber("PPIdx", Long.class);

    public QPaymentPublicEntity(String variable) {
        super(PaymentPublicEntity.class, forVariable(variable));
    }

    public QPaymentPublicEntity(Path<? extends PaymentPublicEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPaymentPublicEntity(PathMetadata metadata) {
        super(PaymentPublicEntity.class, metadata);
    }

}

