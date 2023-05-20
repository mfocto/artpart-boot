package org.ict.artpartM.seesul.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.seesul.entity.ScheckEntity;
import org.ict.artpartM.seesul.entity.SeesulEntity;
import org.ict.artpartM.seesul.model.dto.ScheckDto;
import org.ict.artpartM.seesul.model.service.ScheckService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class ScheckController {
    private final ScheckService scheckService;
    //조회용
    @GetMapping("/scheck/{id}")
    public Header<List<ScheckDto>>  scheckList(@PathVariable long id){ return scheckService.getScheckList(id); }
    //등록용
    @PostMapping("/scheck")
    public List<ScheckEntity> create(@RequestBody List<ScheckDto> scheckDtoList){ return  scheckService.create(scheckDtoList); }
    //수정용
    @PatchMapping("/scheck")
    public List<ScheckEntity> update(@RequestBody List<ScheckDto> scheckDtoList){ return scheckService.update(scheckDtoList); }
}
