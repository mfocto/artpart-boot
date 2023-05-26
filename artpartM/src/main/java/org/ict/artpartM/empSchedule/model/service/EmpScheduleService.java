package org.ict.artpartM.empSchedule.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.empSchedule.entity.EmpScheduleRepository;
import org.ict.artpartM.empSchedule.entity.EventEntity;
import org.ict.artpartM.empSchedule.entity.EventRepository;
import org.ict.artpartM.empSchedule.model.dto.EventDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmpScheduleService {

    private final EventRepository eventRepository;


    public Header<List<EventDto>> getAllEvents() {
        List<EventDto> eventDtos = new ArrayList<>();
        List<EventEntity> eventEntities = eventRepository.findAll();
        for(EventEntity entity : eventEntities){
            EventDto eventDto = EventDto.builder()
                    .eventId(entity.getEventId())
                    .title(entity.getTitle())
                    .start(entity.getStart().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .end(entity.getEnd().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .backgroundColor(entity.getBackgroundColor())
                    .description(entity.getDescription())
                    .build();

            eventDtos.add(eventDto);
        }
        return Header.OK(eventDtos);
    }

    //공지글 가져오기
    public EventDto getEvents(Long id) {
        EventEntity entity = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("스케줄을 찾을 수 없습니다."));
        return EventDto.builder()
                .eventId(entity.getEventId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .backgroundColor(entity.getBackgroundColor())
                .start(entity.getStart().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .end(entity.getEnd().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .build();
    }

    public EventEntity create(EventDto eventDto) {
        EventEntity entity = EventEntity.builder()
                .eventId(eventDto.getEventId())
                .title(eventDto.getTitle())
                .description(eventDto.getDescription())
                .backgroundColor(eventDto.getBackgroundColor())
                .start(LocalDateTime.parse(eventDto.getStart()))
                .end(LocalDateTime.parse(eventDto.getEnd()))
                .build();
        return eventRepository.save(entity);
    }

    public EventEntity update(EventDto eventDto) {
        EventEntity entity = eventRepository.findById(eventDto.getEventId()).orElseThrow(() -> new RuntimeException("스케줄을 찾을 수 없습니다."));
        entity.setTitle(eventDto.getTitle());
        entity.setDescription(eventDto.getDescription());
        entity.setBackgroundColor(eventDto.getBackgroundColor());
        entity.setStart(LocalDateTime.parse(eventDto.getStart()));
        entity.setEnd(LocalDateTime.parse(eventDto.getEnd()));
        return eventRepository.save(entity);
    }

    public void delete(Long id) {
        EventEntity entity = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("스케줄을 찾을 수 없습니다."));
        eventRepository.delete(entity);
    }
}
