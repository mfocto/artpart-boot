package org.ict.artpartM.member.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MinoneRepository extends JpaRepository<MinoneEntity , Long> {
    MinoneEntity findByMinidx(long minidx);
}
