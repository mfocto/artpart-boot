package org.ict.artpartM.member.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findByMemberidx(long memberidx);

    MemberEntity findByMemberdongAndMemberho(String memberdong, String memberho);
}
