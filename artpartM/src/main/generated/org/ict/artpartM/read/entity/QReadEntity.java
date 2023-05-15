package org.ict.artpartM.read.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReadEntity is a Querydsl query type for ReadEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReadEntity extends EntityPathBase<ReadEntity> {

    private static final long serialVersionUID = -1719653883L;

    public static final QReadEntity readEntity = new QReadEntity("readEntity");

    public final NumberPath<Long> electric = createNumber("electric", Long.class);

    public final NumberPath<Long> heat = createNumber("heat", Long.class);

    public final NumberPath<Long> hotwater = createNumber("hotwater", Long.class);

    public final DateTimePath<java.time.LocalDateTime> readdate = createDateTime("readdate", java.time.LocalDateTime.class);

    public final NumberPath<Long> readidx = createNumber("readidx", Long.class);

    public final NumberPath<Long> water = createNumber("water", Long.class);

    public QReadEntity(String variable) {
        super(ReadEntity.class, forVariable(variable));
    }

    public QReadEntity(Path<? extends ReadEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReadEntity(PathMetadata metadata) {
        super(ReadEntity.class, metadata);
    }

}

