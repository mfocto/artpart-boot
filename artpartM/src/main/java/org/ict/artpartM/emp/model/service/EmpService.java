package org.ict.artpartM.emp.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.emp.entity.EmpEntity;
import org.ict.artpartM.emp.entity.EmpRepository;
import org.ict.artpartM.emp.model.dto.EmpDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmpService {

    private final EmpRepository empRepository;
    private final PasswordEncoder passwordEncoder;

    public EmpEntity testinsert() {
        EmpEntity entity = EmpEntity.builder()
                .empId("so여물")
                .empPwd(passwordEncoder.encode("duanf"))
                .empPermanentId("1")
                .empName("송영욱")
                .empAddress("1")
                .empPhone("1")
                .empAuth("ROLE_EMP")
                .build();

        return empRepository.save(entity);
    }

    public EmpDto getEmp(String empId) {
        EmpEntity entity = empRepository.findByEmpId(empId);
        EmpDto dto = EmpDto.builder()
                .empId(entity.getEmpId())
                .empIdx(entity.getEmpIdx())
                .empEmail(entity.getEmpEmail())
                .empAddress(entity.getEmpAddress())
                .empName(entity.getEmpName())
                .empPhone(entity.getEmpPhone())
                .build();

        return dto;
    }
}
