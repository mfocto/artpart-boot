package org.ict.artpartM.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.member.entity.MeetingEntity;
import org.ict.artpartM.member.model.dto.MeetingDto;
import org.ict.artpartM.member.model.service.MeetingService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class MeetingController {
    private final MeetingService meetingService;

    @GetMapping("/meeting/list")
    public Header<List<MeetingDto>> meetingList(
            @PageableDefault(sort = {"meetingidx"}) Pageable pageable,
            SearchCondition searchCondition) {
        return meetingService.getMeetingList(pageable, searchCondition);
    }

    @GetMapping("/meeting/{id}")
    public MeetingDto getMeeting(@PathVariable Long id) { return meetingService.getMeeting(id); }

    @PostMapping("/meeting")
    public MeetingEntity create(@RequestBody MeetingDto meetingDto) { return meetingService.create(meetingDto); }

    @PatchMapping("/meeting")
    public MeetingEntity update(@RequestBody MeetingDto meetingDto) { return meetingService.update(meetingDto); }

    @DeleteMapping("/meeting/{id}")
    public void delete(@PathVariable Long id) { meetingService.delete(id); }


}
