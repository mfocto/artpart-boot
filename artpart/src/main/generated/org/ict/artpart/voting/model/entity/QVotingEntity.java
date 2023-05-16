package org.ict.artpart.voting.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QVotingEntity is a Querydsl query type for VotingEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVotingEntity extends EntityPathBase<VotingEntity> {

    private static final long serialVersionUID = -265819745L;

    public static final QVotingEntity votingEntity = new QVotingEntity("votingEntity");

    public final StringPath answer1 = createString("answer1");

    public final StringPath answer2 = createString("answer2");

    public final StringPath answer3 = createString("answer3");

    public final StringPath answer4 = createString("answer4");

    public final StringPath answer5 = createString("answer5");

    public final StringPath category = createString("category");

    public final DateTimePath<java.time.LocalDateTime> endTime = createDateTime("endTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> memberIdx = createNumber("memberIdx", Long.class);

    public final DateTimePath<java.time.LocalDateTime> startTime = createDateTime("startTime", java.time.LocalDateTime.class);

    public final StringPath title = createString("title");

    public final NumberPath<Long> votingIdx = createNumber("votingIdx", Long.class);

    public QVotingEntity(String variable) {
        super(VotingEntity.class, forVariable(variable));
    }

    public QVotingEntity(Path<? extends VotingEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVotingEntity(PathMetadata metadata) {
        super(VotingEntity.class, metadata);
    }

}

