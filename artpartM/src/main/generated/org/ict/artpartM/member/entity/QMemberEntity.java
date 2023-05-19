package org.ict.artpartM.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberEntity is a Querydsl query type for MemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberEntity extends EntityPathBase<MemberEntity> {

    private static final long serialVersionUID = 336914893L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberEntity memberEntity = new QMemberEntity("memberEntity");

    public final org.ict.artpartM.apt.entity.QAptEntity aptidx;

    public final StringPath memberdong = createString("memberdong");

    public final StringPath memberho = createString("memberho");

    public final StringPath memberid = createString("memberid");

    public final NumberPath<Long> memberidx = createNumber("memberidx", Long.class);

    public final StringPath memberloginok = createString("memberloginok");

    public final StringPath membermycar1 = createString("membermycar1");

    public final StringPath membermycar2 = createString("membermycar2");

    public final StringPath membername = createString("membername");

    public final StringPath memberpassword = createString("memberpassword");

    public final StringPath memberphone = createString("memberphone");

    public QMemberEntity(String variable) {
        this(MemberEntity.class, forVariable(variable), INITS);
    }

    public QMemberEntity(Path<? extends MemberEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberEntity(PathMetadata metadata, PathInits inits) {
        this(MemberEntity.class, metadata, inits);
    }

    public QMemberEntity(Class<? extends MemberEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.aptidx = inits.isInitialized("aptidx") ? new org.ict.artpartM.apt.entity.QAptEntity(forProperty("aptidx")) : null;
    }

}

