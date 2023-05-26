package org.ict.artpart.seesul.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QScheckEntity is a Querydsl query type for ScheckEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScheckEntity extends EntityPathBase<ScheckEntity> {

    private static final long serialVersionUID = -1981352990L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QScheckEntity scheckEntity = new QScheckEntity("scheckEntity");

    public final NumberPath<Long> scheck = createNumber("scheck", Long.class);

    public final NumberPath<Long> scheckidx = createNumber("scheckidx", Long.class);

    public final QSeesulEntity sidx;

    public final StringPath sprocess = createString("sprocess");

    public final StringPath sresult = createString("sresult");

    public QScheckEntity(String variable) {
        this(ScheckEntity.class, forVariable(variable), INITS);
    }

    public QScheckEntity(Path<? extends ScheckEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QScheckEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QScheckEntity(PathMetadata metadata, PathInits inits) {
        this(ScheckEntity.class, metadata, inits);
    }

    public QScheckEntity(Class<? extends ScheckEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.sidx = inits.isInitialized("sidx") ? new QSeesulEntity(forProperty("sidx"), inits.get("sidx")) : null;
    }

}

