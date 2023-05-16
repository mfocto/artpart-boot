package org.ict.artpart.apt.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAptEntity is a Querydsl query type for AptEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAptEntity extends EntityPathBase<AptEntity> {

    private static final long serialVersionUID = -1457557156L;

    public static final QAptEntity aptEntity = new QAptEntity("aptEntity");

    public final StringPath aptAdd = createString("aptAdd");

    public final NumberPath<Integer> aptCount = createNumber("aptCount", Integer.class);

    public final NumberPath<Long> aptIdx = createNumber("aptIdx", Long.class);

    public final StringPath aptPhone = createString("aptPhone");

    public final NumberPath<Integer> aptRCount = createNumber("aptRCount", Integer.class);

    public final StringPath aptRoad = createString("aptRoad");

    public QAptEntity(String variable) {
        super(AptEntity.class, forVariable(variable));
    }

    public QAptEntity(Path<? extends AptEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAptEntity(PathMetadata metadata) {
        super(AptEntity.class, metadata);
    }

}

