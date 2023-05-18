package org.ict.artpartM.member.entity;


import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<MeetingEntity , Long> {
    MeetingEntity findByMeetingidx(long meetingidx);
}
