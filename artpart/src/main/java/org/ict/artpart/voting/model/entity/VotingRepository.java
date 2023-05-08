package org.ict.artpart.voting.model.entity;

import org.ict.artpart.voting.model.entity.VotingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotingRepository extends JpaRepository<VotingEntity, Long>{
}
