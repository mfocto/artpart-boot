package org.ict.artpartM.member.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<ReplyEntity , Long> {
    ReplyEntity findByVotingidx(long votingidx);
}
