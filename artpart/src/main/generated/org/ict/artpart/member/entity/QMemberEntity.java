package org.ict.artpart.member.entity;

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

    private static final long serialVersionUID = -1692809142L;

    public static final QMemberEntity memberEntity = new QMemberEntity("memberEntity");

    public final StringPath memberAdd = createString("memberAdd");

    public final StringPath memberDong = createString("memberDong");

    public final StringPath memberHo = createString("memberHo");

    public final StringPath memberId = createString("memberId");

    public final NumberPath<Long> memberIdx = createNumber("memberIdx", Long.class);

    public final StringPath memberLoginOK = createString("memberLoginOK");

    public final StringPath memberName = createString("memberName");

    public final StringPath memberPhone = createString("memberPhone");

    public final StringPath memberPw = createString("memberPw");

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

