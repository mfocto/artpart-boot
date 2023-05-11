package org.ict.artpart.minone.model.entity;

import org.ict.artpart.minone.model.dto.MinoneDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;



@Repository
public interface MinoneRepository extends JpaRepository<MinoneEntity, Long>  {


    //민원 정보 전체리스트 조회
    List<MinoneEntity> findByMemberIdx(Long memberIdx);
}
