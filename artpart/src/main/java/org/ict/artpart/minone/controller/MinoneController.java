package org.ict.artpart.minone.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.minone.model.service.MinoneService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class MinoneController {
    private final MinoneService memberService;

}
