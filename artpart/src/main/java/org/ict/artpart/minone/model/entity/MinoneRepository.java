package org.ict.artpart.minone.model.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MinoneRepository extends JpaRepository<MinoneEntity, Long>  {
    //JpaRepository를 extends 받아서, 해당 Repository로 JPA의 대부분의 자동 쿼리 기능을 수행할 수 있도록 함
    //해당 클래스 안에 메소드를 선언하고위에 @Query를 넣어주면 JPA에서 커스텀 쿼리를 사용할 수 있음
    //파라미터는 :name 과 같이 :를 앞에 붙이는 것으로 파라미터 지정 가능
    /* 예시)
    @Query(value = "select name, age from sample_member where name = :name", nativeQuery=true)
    List<CrudEntity> searchParamRepo(@Param("name") String name);
    */

    MinoneEntity findByMemberidx(long memberidx);
    MinoneEntity findByMinidx(long minidx);
}
