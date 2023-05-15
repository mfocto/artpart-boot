package org.ict.artpart.member.entity;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findByMemberId(String memberId);
}
