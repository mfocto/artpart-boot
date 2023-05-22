package org.ict.artpartM.member.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VotingRepository extends JpaRepository<VotingEntity, Long> {
    VotingEntity findByVotingidx(long votingidx);
}
