package org.ict.artpartM.empSchedule.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.empSchedule.model.service.EmpScheduleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class EmpScheduleController {
    private final EmpScheduleService empScheduleService;
}
