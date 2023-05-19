package org.ict.artpartM.read.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReadEntity is a Querydsl query type for ReadEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReadEntity extends EntityPathBase<ReadEntity> {

    private static final long serialVersionUID = -1719653883L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReadEntity readEntity = new QReadEntity("readEntity");

    public final NumberPath<Long> electric = createNumber("electric", Long.class);

    public final NumberPath<Long> heat = createNumber("heat", Long.class);

    public final NumberPath<Long> hotwater = createNumber("hotwater", Long.class);

    public final org.ict.artpartM.member.entity.QMemberEntity memberidx;

    public final DateTimePath<java.time.LocalDateTime> readdate = createDateTime("readdate", java.time.LocalDateTime.class);

    public final NumberPath<Long> readidx = createNumber("readidx", Long.class);

    public final NumberPath<Long> water = createNumber("water", Long.class);

    public QReadEntity(String variable) {
        this(ReadEntity.class, forVariable(variable), INITS);
    }

    public QReadEntity(Path<? extends ReadEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReadEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReadEntity(PathMetadata metadata, PathInits inits) {
        this(ReadEntity.class, metadata, inits);
    }

    public QReadEntity(Class<? extends ReadEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberidx = inits.isInitialized("memberidx") ? new org.ict.artpartM.member.entity.QMemberEntity(forProperty("memberidx"), inits.get("memberidx")) : null;
    }

}

