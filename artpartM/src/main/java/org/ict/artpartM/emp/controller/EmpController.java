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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

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
    //직원 마이 페이지 이동

    //직원 정보 출력



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

//    //직원 등록
    @PostMapping("/admin")
    public EmpEntity createEmp(@RequestBody EmpDto empDto){
        return empService.createEmp(empDto);
    }



    //직원 수정
    @PatchMapping("/admin")//직원 수정
    public EmpEntity updateEmp(@RequestBody EmpDto empDto){
        return empService.updateEmp(empDto);
    }


    // 직원 사진 저장
//    @PostMapping("/imgUp")
//    public EmpEntity createEmpImg(@RequestParam("empImg") MultipartFile empImg, @RequestBody EmpDto empDto) {
//        empDto.setEmpImg(String.valueOf(empImg));
//        return empService.createEmpImg(empDto);
//    }


}
