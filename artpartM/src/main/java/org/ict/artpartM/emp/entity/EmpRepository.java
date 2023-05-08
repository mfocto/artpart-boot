package org.ict.artpartM.emp.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<EmpEntity, Long> {
    EmpEntity findByEmpId(String empId);
}
