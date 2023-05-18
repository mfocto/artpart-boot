package org.ict.artpartM.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberEntity is a Querydsl query type for MemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberEntity extends EntityPathBase<MemberEntity> {

    private static final long serialVersionUID = 336914893L;

    public static final QMemberEntity memberEntity = new QMemberEntity("memberEntity");

    public final NumberPath<AptEntity> aptidx = createNumber("aptidx", AptEntity.class);

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
        super(MemberEntity.class, forVariable(variable));
    }

    public QMemberEntity(Path<? extends MemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberEntity(PathMetadata metadata) {
        super(MemberEntity.class, metadata);
    }

}

