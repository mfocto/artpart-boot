package org.ict.artpartM.seesul.entity;


import org.springframework.data.jpa.repository.JpaRepository;

public interface SeesulRepository extends JpaRepository<SeesulEntity, Long> {
    SeesulEntity findBySidx(long sidx);
}
