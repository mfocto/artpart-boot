package org.ict.artpartM.company.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity,Long> {
    CompanyEntity findByCompanyidx(long companyidx);
}
