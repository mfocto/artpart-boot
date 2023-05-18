package org.ict.artpartM.emp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.emp.entity.EmpEntity;
import org.ict.artpartM.emp.model.dto.EmpDto;
import org.ict.artpartM.emp.model.service.EmpService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class EmpController {
    private final EmpService empService;

    @PostMapping("/testinsert")
    public Header<EmpEntity> testinsert() {

        return Header.OK(empService.testinsert());
    }

    @GetMapping("/emp/{empId}")
    public Header<EmpDto> getEmp(@PathVariable String empId){
        if(empId != null){
            return Header.OK(empService.getEmp(empId));
        } else {
            return Header.ERROR("존재하지 않는 아이디 입니다.");
        }
    }
}
