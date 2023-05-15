package org.ict.artpart.using.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsingEntity is a Querydsl query type for UsingEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUsingEntity extends EntityPathBase<UsingEntity> {

    private static final long serialVersionUID = -1006905028L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUsingEntity usingEntity = new QUsingEntity("usingEntity");

    public final StringPath bankNumber = createString("bankNumber");

    public final NumberPath<Long> detailIdx = createNumber("detailIdx", Long.class);

    public final org.ict.artpart.member.entity.QMemberEntity memberIdx;

    public final StringPath paymentBank = createString("paymentBank");

    public final DatePath<java.sql.Date> paymentDadLine = createDate("paymentDadLine", java.sql.Date.class);

    public final DatePath<java.sql.Date> paymentDate = createDate("paymentDate", java.sql.Date.class);

    public final NumberPath<Integer> paymentMoney = createNumber("paymentMoney", Integer.class);

    public final StringPath paymentStatus = createString("paymentStatus");

    public QUsingEntity(String variable) {
        this(UsingEntity.class, forVariable(variable), INITS);
    }

    public QUsingEntity(Path<? extends UsingEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUsingEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUsingEntity(PathMetadata metadata, PathInits inits) {
        this(UsingEntity.class, metadata, inits);
    }

    public QUsingEntity(Class<? extends UsingEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberIdx = inits.isInitialized("memberIdx") ? new org.ict.artpart.member.entity.QMemberEntity(forProperty("memberIdx"), inits.get("memberIdx")) : null;
    }

}

