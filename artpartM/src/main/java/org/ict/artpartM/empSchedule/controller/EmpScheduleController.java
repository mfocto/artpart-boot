package org.ict.artpartM.empSchedule.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.empSchedule.entity.EventEntity;
import org.ict.artpartM.empSchedule.model.dto.EventDto;
import org.ict.artpartM.empSchedule.model.service.EmpScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Handler;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class EmpScheduleController {
    private final EmpScheduleService empScheduleService;

    @GetMapping("/schedule/list")
    public Header<List<EventDto>> getAllEvents(){
        return empScheduleService.getAllEvents();
    }

    @GetMapping("/schedule/{id}")
    public EventDto getEvent(@PathVariable Long id){
        return empScheduleService.getEvents(id);
    }

    @PostMapping("/schedule")
    public EventEntity create(@RequestBody EventDto eventDto){
        return empScheduleService.create(eventDto);
    }

    @PatchMapping("/schedule")
    public EventEntity update(@RequestBody EventDto eventDto){
        return empScheduleService.update(eventDto);
    }

    @DeleteMapping("/schedule/{id}")
    public void delete(@PathVariable Long id){
        empScheduleService.delete(id);
    }
}
