package org.ict.artpartM.common.repository;


import org.ict.artpartM.common.domain.PerformanceLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceLogRepository extends JpaRepository<PerformanceLog, Long> {
	
}
