package org.ict.artpartM.emp.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.emp.entity.EmpRepository;
import org.ict.artpartM.emp.model.dto.EmpDto;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmpService {

    private final EmpRepository empRepository;

    public EmpDto login(String empId, String empPwd) {
        if(empId == null){
            return null;
        }

        if(empPwd.equals(empRepository.findByEmpId(empId).getEmpPwd())){
            return EmpDto.builder()
                    .empIdx(empRepository.findByEmpId(empId).getEmpIdx())
                    .empId(empRepository.findByEmpId(empId).getEmpId())
                    .empPwd(empRepository.findByEmpId(empId).getEmpPwd())
                    .empAddress(empRepository.findByEmpId(empId).getEmpAddress())
                    .empEmail(empRepository.findByEmpId(empId).getEmpEmail())
                    .empJobId(empRepository.findByEmpId(empId).getEmpJobId())
                    .empPhone(empRepository.findByEmpId(empId).getEmpPhone())
                    .empHireDate(empRepository.findByEmpId(empId).getEmpHireDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .empDepartureDate(empRepository.findByEmpId(empId).getEmpDepartureDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .empDepartmentId(empRepository.findByEmpId(empId).getEmpDepartmentId())
                    .empCar(empRepository.findByEmpId(empId).getEmpCar())
                    .empName(empRepository.findByEmpId(empId).getEmpName())
                    .empPermanentId(empRepository.findByEmpId(empId).getEmpPermanentId())
                    .empImg(empRepository.findByEmpId(empId).getEmpImg())
                    .empImgUp(empRepository.findByEmpId(empId).getEmpImgUp())
                    .build();
        } else {
            return null;
        }
    }
}
