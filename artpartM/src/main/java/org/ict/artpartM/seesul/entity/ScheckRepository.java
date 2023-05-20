package org.ict.artpartM.seesul.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheckRepository extends JpaRepository<ScheckEntity, Long> {
    List<ScheckEntity> findAllBySidx(SeesulEntity sidx);

    ScheckEntity findByScheckidx(long scheckidx);
}
