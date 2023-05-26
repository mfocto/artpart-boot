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

    public final NumberPath<Long> memberidx = createNumber("memberidx", Long.class);

    public final StringPath mincategory = createString("mincategory");

    public final NumberPath<Long> minidx = createNumber("minidx", Long.class);

    public final StringPath minres = createString("minres");

    public final StringPath minstatus = createString("minstatus");

    public final StringPath mintitle = createString("mintitle");

    public final StringPath mintype = createString("mintype");

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

