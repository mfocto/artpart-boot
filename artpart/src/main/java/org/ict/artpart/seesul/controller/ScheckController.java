package org.ict.artpart.seesul.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
import org.ict.artpart.seesul.model.dto.ScheckDto;
import org.ict.artpart.seesul.model.service.ScheckService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class ScheckController {
    private final ScheckService scheckService;
    //조회용
    @GetMapping("/scheck/{id}")
    public Header<List<ScheckDto>> scheckList(@PathVariable Long id){
        return scheckService.getScheckList(id);
    }

}
