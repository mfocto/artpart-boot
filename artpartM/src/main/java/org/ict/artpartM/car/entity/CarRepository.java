package org.ict.artpartM.car.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity,Long> {
    CarEntity findByCarIdx(long carIdx);
}
