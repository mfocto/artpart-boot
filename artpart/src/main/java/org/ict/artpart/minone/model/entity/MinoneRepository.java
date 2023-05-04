package org.ict.artpart.minone.model.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinoneRepository extends JpaRepository<MinoneEntity, Long>  {
}
