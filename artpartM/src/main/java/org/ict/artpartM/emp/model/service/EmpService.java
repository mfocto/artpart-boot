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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.ict.artpartM.common.Pagination;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
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
                .empIdx(entity.getEmpIdx())
                .empId(entity.getEmpId())
                .empEmail(entity.getEmpEmail())
                .empAddress(entity.getEmpAddress())
                .empName(entity.getEmpName())
                .empPhone(entity.getEmpPhone())
                .build();

        return dto;
    }

    //직원 리스트 출력
    public Header<List<EmpDto>> empList(Pageable pageable, SearchCondition searchCondition) {
        try{
            List<EmpDto> empList = new ArrayList<>();

            Page<EmpEntity> empEntities = empRepositoryCustom.findAllBySearchCondition(pageable,searchCondition);
            for (EmpEntity entity : empEntities){
                EmpDto empDto = EmpDto.builder()
                        .empIdx(entity.getEmpIdx())
                        .empId(entity.getEmpId() != null ? entity.getEmpId() : null)
                        .empPermanentId(entity.getEmpPermanentId() != null ? entity.getEmpPermanentId() : null)
                        .empJobId(entity.getEmpJobId() != null ? entity.getEmpJobId() : null)
                        .empDepartmentId(entity.getEmpDepartmentId() != null ? entity.getEmpDepartmentId() :  null)
                        .empName(entity.getEmpName() != null ? entity.getEmpName() : null)
                        .empEmail(entity.getEmpEmail() != null ? entity.getEmpEmail() : null)
                        .empAddress(entity.getEmpAddress() != null ? entity.getEmpAddress() : null)
                        .empPhone(entity.getEmpPhone() != null ? entity.getEmpPhone() : null)
                        .empHireDate(entity.getEmpHireDate() != null ? entity.getEmpHireDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null)
                        .empDepartureDate(entity.getEmpDepartureDate() != null ? entity.getEmpDepartureDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) :null)
                        .empCar(entity.getEmpCar() != null ? entity.getEmpCar() : null)
                        .empMemo(entity.getEmpMemo() != null ? entity.getEmpMemo() : null)
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
        }catch (NullPointerException e) {
            // 예외 처리
            e.printStackTrace(); // 예외 정보 출력 (개발 중에만 사용)
            return Header.ERROR("NullPointerException occurred");
        }

    }

    //직원 정보(하나) 갖고오기
    public EmpDto getEmpList(Long id) {
        EmpEntity entity = empRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return EmpDto.builder()
                .empIdx(entity.getEmpIdx())
                .empId(entity.getEmpId() != null ? entity.getEmpId() : null)
                .empPermanentId(entity.getEmpPermanentId() != null ? entity.getEmpPermanentId() : null)
                .empJobId(entity.getEmpJobId() != null ? entity.getEmpJobId() : null)
                .empDepartmentId(entity.getEmpDepartmentId() != null ? entity.getEmpDepartmentId() : null)
                .empName(entity.getEmpName() != null ? entity.getEmpName() : null)
                .empEmail(entity.getEmpEmail() != null ? entity.getEmpEmail() : null)
                .empAddress(entity.getEmpAddress() != null ? entity.getEmpAddress() : null)
                .empPhone(entity.getEmpPhone() != null ? entity.getEmpPhone() : null)
                .empHireDate(entity.getEmpHireDate() != null ? entity.getEmpHireDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null)
                .empDepartureDate(entity.getEmpDepartureDate() != null ? entity.getEmpDepartureDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null)
                .empCar(entity.getEmpCar() != null ? entity.getEmpCar() : null)
                .empImg(entity.getEmpImg() != null ? entity.getEmpImg() : null)
                .empImgUp(entity.getEmpImgUp() != null? entity.getEmpImgUp() : null)
                .empMemo(entity.getEmpMemo() != null? entity.getEmpMemo() : null)
                .build();
    }

    //직원 정보 생성
    public EmpEntity createEmp(EmpDto empDto) {
        EmpEntity entity = EmpEntity.builder()
                .empId(empDto.getEmpId())
                .empPermanentId(empDto.getEmpPermanentId())
                .empDepartmentId(empDto.getEmpDepartmentId())
                .empJobId(empDto.getEmpJobId())
                .empName(empDto.getEmpName())
                .empEmail(empDto.getEmpEmail())
                .empAddress(empDto.getEmpAddress())
                .empPwd(passwordEncoder.encode(empDto.getEmpPwd()))
                .empPhone(empDto.getEmpPhone())
                .empHireDate(LocalDate.parse(empDto.getEmpHireDate()))
                .empImg(empDto.getEmpImg())
                .empCar(empDto.getEmpCar())
                .empImgUp(empDto.getEmpImgUp())
                .empMemo(empDto.getEmpMemo())
                .empAuth("ROLE_EMP")
                .build();
        return  empRepository.save(entity);

    }


    public EmpEntity updateEmp(EmpDto empDto) {
        EmpEntity entity = empRepository.findById(empDto.getEmpIdx()).orElseThrow(() -> new RuntimeException("직원 정보를 찾을 수 없습니다."));

        entity.setEmpId(empDto.getEmpId());
        entity.setEmpPermanentId(empDto.getEmpPermanentId());       //사원 구분 (정규직 , 계약직, 알바)
        entity.setEmpDepartmentId(empDto.getEmpDepartmentId());     //직급 (관리직-행정직, 관리직-경비직, 관리직-청소직, 기술직-전기, 기술직-설비, 기술직-열선)
        entity.setEmpJobId(empDto.getEmpJobId());                   //소속 (반장, 소장, 기사, 사무원, 관리원, 미화원)
        entity.setEmpName(empDto.getEmpName());
        entity.setEmpEmail(empDto.getEmpEmail());
        entity.setEmpAddress(empDto.getEmpAddress());
        entity.setEmpCar(empDto.getEmpCar());
        entity.setEmpPhone(empDto.getEmpPhone());
        entity.setEmpHireDate(LocalDate.parse(empDto.getEmpHireDate()));
        if (empDto.getEmpDepartureDate() != null) {
            entity.setEmpDepartureDate(LocalDate.parse(empDto.getEmpDepartureDate()));
        } else {
            entity.setEmpDepartureDate(null);
        }
//        entity.setEmpDepartureDate(LocalDate.parse(empDto.getEmpDepartureDate()));
        entity.setEmpImg(empDto.getEmpImg());
        entity.setEmpImgUp(empDto.getEmpImgUp());
        entity.setEmpMemo(empDto.getEmpMemo());
        entity.setEmpAuth(empDto.getEmpAuth());
//        if (empDto.getEmpPwd() != null && !empDto.getEmpPwd().equals(entity.getEmpPwd())) {
//            entity.setEmpPwd(passwordEncoder.encode(empDto.getEmpPwd()));
//        }
        return empRepository.save(entity);
    }


//@Value("${spring.servlet.multipart.location}") // 파일 저장 경로를 설정한 프로퍼티
//private String uploadPath;
//public EmpEntity createEmpImg(EmpDto empDto) {
//
//    // 파일 저장
//    String fileName = empDto.getEmpImg(); // 업로드된 파일의 원래 이름
//    String filePath = uploadPath + "/" + fileName; // 저장할 파일 경로
//
//
//    try {
//        // 파일 저장
//        File dest = new File(filePath);
//        File sourceFile = new File(empDto.getEmpImg()); // 업로드된 파일의 경로로 File 객체 생성
//        FileUtils.copyFile(sourceFile, dest); // 파일 복사
//        empDto.setEmpImgUp(filePath);
//    } catch (IOException e) {
//        // 파일 저장 실패 처리
//        // 예외 처리 코드 작성
//        // 파일 저장에 실패한 경우, 예외를 무시하고 넘어감
//        // 로깅 등의 추가 처리가 필요하다면 여기에 작성
//        return null;
//    }
//
//    EmpEntity entity = EmpEntity.builder()
//            .empIdx(empDto.getEmpIdx())
//            .empId(empDto.getEmpId())
//            .empPermanentId(empDto.getEmpPermanentId())
//            .empDepartmentId(empDto.getEmpDepartmentId())
//            .empJobId(empDto.getEmpJobId())
//            .empName(empDto.getEmpName())
//            .empEmail(empDto.getEmpEmail())
//            .empAddress(empDto.getEmpAddress())
//            .empPwd(passwordEncoder.encode(empDto.getEmpPwd()))
//            .empPhone(empDto.getEmpPhone())
//            .empHireDate(LocalDate.parse(empDto.getEmpHireDate()))
//            .empImg(empDto.getEmpImg())
//            .empCar(empDto.getEmpCar())
//            .empImgUp(empDto.getEmpImgUp()) // 파일 경로 설정
//            .empMemo(empDto.getEmpMemo())
//            .empAuth("ROLE_EMP")
//            .build();
//
//    return empRepository.save(entity);
//}




}
