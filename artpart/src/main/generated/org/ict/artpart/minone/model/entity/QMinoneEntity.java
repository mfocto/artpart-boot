package org.ict.artpart.minone.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMinoneEntity is a Querydsl query type for MinoneEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMinoneEntity extends EntityPathBase<MinoneEntity> {

    private static final long serialVersionUID = -1112758023L;

    public static final QMinoneEntity minoneEntity = new QMinoneEntity("minoneEntity");

    public final NumberPath<Long> memberIdx = createNumber("memberIdx", Long.class);

    public final StringPath minCategory = createString("minCategory");

    public final StringPath minFile = createString("minFile");

    public final NumberPath<Long> minIdx = createNumber("minIdx", Long.class);

    public final StringPath minRename = createString("minRename");

    public final StringPath minRes = createString("minRes");

    public final StringPath minStatus = createString("minStatus");

    public final StringPath minTitle = createString("minTitle");

    public final StringPath minType = createString("minType");

    public QMinoneEntity(String variable) {
        super(MinoneEntity.class, forVariable(variable));
    }

    public QMinoneEntity(Path<? extends MinoneEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMinoneEntity(PathMetadata metadata) {
        super(MinoneEntity.class, metadata);
    }

}

