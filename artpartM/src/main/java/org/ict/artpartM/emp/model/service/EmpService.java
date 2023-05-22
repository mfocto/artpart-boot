package org.ict.artpartM.emp.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.emp.entity.EmpEntity;
import org.ict.artpartM.emp.entity.EmpRepository;
import org.ict.artpartM.emp.entity.EmpRepositoryCustom;
import org.ict.artpartM.emp.model.dto.EmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.ict.artpartM.common.Pagination;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmpService {

    private final EmpRepository empRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    private final EmpRepositoryCustom empRepositoryCustom;

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
                .empEmail(entity.getEmpEmail())
                .empAddress(entity.getEmpAddress())
                .empName(entity.getEmpName())
                .empPhone(entity.getEmpPhone())
                .build();

        return dto;
    }

    public Header<List<EmpDto>> empList(Pageable pageable, SearchCondition searchCondition) {
        List<EmpDto> empList = new ArrayList<>();

        Page<EmpEntity> empEntities = empRepositoryCustom.findAllBySearchCondition(pageable,searchCondition);
        for (EmpEntity entity : empEntities){
            EmpDto empDto = EmpDto.builder()
                    .empIdx(entity.getEmpIdx())
                    .empId(entity.getEmpId())
                    .empPermanentId(entity.getEmpPermanentId())
                    .empJobId(entity.getEmpJobId())
                    .empDepartmentId(entity.getEmpDepartmentId())
                    .empName(entity.getEmpName())
                    .empEmail(entity.getEmpEmail())
                    .empAddress(entity.getEmpAddress())
                    .empPhone(entity.getEmpPhone())
                    .empHireDate(String.valueOf(entity.getEmpHireDate().toLocalDate()))
                    .empDepartureDate(String.valueOf(entity.getEmpDepartureDate().toLocalDate()))
                    .empCar(entity.getEmpCar())
                    .empMemo(entity.getEmpMemo())
                    .build();

            empList.add(empDto);
        }

        Pagination pagination = new Pagination(
                (int) empEntities.getTotalElements()
                , pageable.getPageNumber()+1
                ,pageable.getPageSize()
                ,10
        );

        return Header.OK(empList,pagination);
    }

    public EmpDto getEmpList(Long id) {
        EmpEntity entity = empRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return EmpDto.builder()
                .empIdx(entity.getEmpIdx())
                .empId(entity.getEmpId())
                .empPermanentId(entity.getEmpPermanentId())
                .empJobId(entity.getEmpJobId())
                .empDepartmentId(entity.getEmpDepartmentId())
                .empName(entity.getEmpName())
                .empEmail(entity.getEmpEmail())
                .empAddress(entity.getEmpAddress())
                .empPhone(entity.getEmpPhone())
                .empHireDate(entity.getEmpHireDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .empDepartureDate(entity.getEmpDepartureDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .empCar(entity.getEmpCar())
                .empImg(entity.getEmpImg())
                .empImgUp(entity.getEmpImgUp())
                .empMemo(entity.getEmpMemo())
                .build();
    }

    public EmpEntity createEmp(EmpDto empdto) {
        EmpEntity entity = EmpEntity.builder()
                .empIdx(empdto.getEmpIdx())
                .empId(empdto.getEmpId())
                .empPermanentId(empdto.getEmpDepartmentId())
                .empDepartmentId(empdto.getEmpDepartmentId())
                .empJobId(empdto.getEmpJobId())
                .empName(empdto.getEmpName())
                .empEmail(empdto.getEmpEmail())
                .empAddress(empdto.getEmpAddress())
                .empPwd(passwordEncoder.encode(empdto.getEmpPwd()))
                .empHireDate(LocalDateTime.parse(empdto.getEmpHireDate()))
                .empImg(empdto.getEmpImg())
                .empMemo(empdto.getEmpMemo())
                .empAuth(empdto.getEmpAuth())
                .build();
        return  empRepository.save(entity);

    }

    public EmpEntity updateEmp(EmpDto empDto) {
        EmpEntity entity = empRepository.findByEmpIdx(empDto.getEmpIdx());
        entity.setEmpId(empDto.getEmpId());
        entity.setEmpPermanentId(empDto.getEmpPermanentId());
        entity.setEmpDepartmentId(empDto.getEmpDepartmentId());
        entity.setEmpJobId(empDto.getEmpJobId());
        entity.setEmpName(empDto.getEmpName());
        entity.setEmpEmail(empDto.getEmpEmail());
        entity.setEmpAddress(empDto.getEmpAddress());
        entity.setEmpCar(empDto.getEmpCar());
        entity.setEmpPhone(empDto.getEmpPhone());
        entity.setEmpHireDate(LocalDateTime.parse(empDto.getEmpHireDate()));
        entity.setEmpDepartureDate(LocalDateTime.parse(empDto.getEmpDepartureDate()));
        entity.setEmpImg(empDto.getEmpImg());
        entity.setEmpImgUp(empDto.getEmpImgUp());
        entity.setEmpMemo(empDto.getEmpMemo());
        return empRepository.save(entity);
    }

    public EmpEntity updateEmpDepartureDate(EmpDto empDto) {
        EmpEntity entity = empRepository.findByEmpIdx(empDto.getEmpIdx());
        entity.setEmpId(empDto.getEmpId());
        entity.setEmpPermanentId(empDto.getEmpPermanentId());
        entity.setEmpDepartmentId(empDto.getEmpDepartmentId());
        entity.setEmpJobId(empDto.getEmpJobId());
        entity.setEmpName(empDto.getEmpName());
        entity.setEmpEmail(empDto.getEmpEmail());
        entity.setEmpAddress(empDto.getEmpAddress());
        entity.setEmpCar(empDto.getEmpCar());
        entity.setEmpPhone(empDto.getEmpPhone());
        entity.setEmpHireDate(LocalDateTime.parse(empDto.getEmpHireDate()));
        entity.setEmpDepartureDate(LocalDateTime.parse(empDto.getEmpDepartureDate()));
        entity.setEmpImg(empDto.getEmpImg());
        entity.setEmpImgUp(empDto.getEmpImgUp());
        entity.setEmpMemo(empDto.getEmpMemo());
        return empRepository.save(entity);
    }
}
