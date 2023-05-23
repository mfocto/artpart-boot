package org.ict.artpartM.emp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.emp.entity.EmpEntity;
import org.ict.artpartM.emp.model.dto.EmpDto;
import org.ict.artpartM.emp.model.service.EmpService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    //직원 리스트 출력
    @GetMapping("/admin/list")
    public Header<List<EmpDto>> empList(@PageableDefault(sort = {"emp_idx"}) Pageable pageable,
                                           SearchCondition searchCondition){
        return empService.empList(pageable,searchCondition);
    }

    //직원 상세 정보
    @GetMapping("/admin/{id}")
    public EmpDto getEmpList(@PathVariable Long id){
        return empService.getEmpList(id);
    }

    //직원 등록
    @PostMapping("/admin")//create==Post
    public EmpEntity createEmp(@RequestBody EmpDto empdto){
        return empService.createEmp(empdto);
    }
    //직원 수정
    @PatchMapping("/admin/change")//직원 수정
    public EmpEntity updateEmp(@RequestBody EmpDto empDto){
        return empService.updateEmp(empDto);
    }

    @PatchMapping("/admin/departureDate") //직원 퇴사
    public EmpEntity updateEmpDepartureDate(@RequestBody EmpDto empDto){
        return empService.updateEmpDepartureDate(empDto);
    }
}
