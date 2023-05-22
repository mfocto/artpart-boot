package org.ict.artpartM.empSchedule.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.empSchedule.entity.EmpScheduleRepository;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmpScheduleService {
    private final EmpScheduleRepository empScheduleRepository;
}
