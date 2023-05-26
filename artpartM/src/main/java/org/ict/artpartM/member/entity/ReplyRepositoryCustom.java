package org.ict.artpartM.member.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static org.ict.artpartM.member.entity.QReplyEntity.replyEntity;

@RequiredArgsConstructor
@Repository
public class ReplyRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    public long answer1(VotingEntity votingid){
        JPAQuery<ReplyEntity> query = queryFactory.selectFrom(replyEntity)
                .where(answer1count(votingid));
        long total = query.stream().count();
        return total;
    }

    public BooleanExpression answer1count(VotingEntity votingid){
        return replyEntity.votingidx.eq(votingid).and(replyEntity.replyid.eq(1L));
    }

    public long answer2(VotingEntity votingid){
        JPAQuery<ReplyEntity> query = queryFactory.selectFrom(replyEntity)
                .where(answer2count(votingid));
        long total = query.stream().count();
        return total;
    }

    public BooleanExpression answer2count(VotingEntity votingid){
        return replyEntity.votingidx.eq(votingid).and(replyEntity.replyid.eq(2L));
    }

    public long answer3(VotingEntity votingid){
        JPAQuery<ReplyEntity> query = queryFactory.selectFrom(replyEntity)
                .where(answer3count(votingid));
        long total = query.stream().count();
        return total;
    }

    public BooleanExpression answer3count(VotingEntity votingid){
        return replyEntity.votingidx.eq(votingid).and(replyEntity.replyid.eq(3L));
    }

    public long answer4(VotingEntity votingid){
        JPAQuery<ReplyEntity> query = queryFactory.selectFrom(replyEntity)
                .where(answer4count(votingid));
        long total = query.stream().count();
        return total;
    }

    public BooleanExpression answer4count(VotingEntity votingid){
        return replyEntity.votingidx.eq(votingid).and(replyEntity.replyid.eq(4L));
    }

    public long answer5(VotingEntity votingid){
        JPAQuery<ReplyEntity> query = queryFactory.selectFrom(replyEntity)
                .where(answer5count(votingid));
        long total = query.stream().count();
        return total;
    }

    public BooleanExpression answer5count(VotingEntity votingid){
        return replyEntity.votingidx.eq(votingid).and(replyEntity.replyid.eq(5L));
    }

}
