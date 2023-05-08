package org.ict.artpartM.emp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.emp.model.dto.EmpDto;
import org.ict.artpartM.emp.model.service.EmpService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class EmpController {
    private final EmpService empService;

    @GetMapping("/login/{empid}")
    public Header<EmpDto> login(@PathVariable String empid, @RequestParam("emppwd") String emppwd){
        EmpDto empdto =empService.login(empid, emppwd);

        if(empdto != null){
            return Header.OK(empdto);
        } else {
            return Header.ERROR("로그인 실패!");
        }
    }
}
