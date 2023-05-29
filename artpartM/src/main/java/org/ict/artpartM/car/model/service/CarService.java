package org.ict.artpartM.car.model.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.car.entity.CarEntity;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.car.entity.CarRepository;
import org.ict.artpartM.car.entity.CarRepositoryCustom;
import org.ict.artpartM.car.model.dto.CarDto;
import org.ict.artpartM.common.Pagination;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.emp.entity.EmpEntity;
import org.ict.artpartM.emp.entity.EmpRepository;
import org.ict.artpartM.emp.model.dto.EmpDto;
import org.ict.artpartM.member.entity.MemberEntity;
import org.ict.artpartM.member.entity.MemberRepository;
import org.ict.artpartM.member.model.dto.MemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository carRepository;
    private final CarRepositoryCustom carRepositoryCustom;
    private final MemberRepository memberRepository;
    private final EmpRepository empRepository;

    public Header<List<CarDto>> getCarList(Pageable pageable, SearchCondition searchCondition) {
        List<CarDto> carList = new ArrayList<>();

        Page<CarEntity> carEntities = carRepositoryCustom.findAllBySearchCondition(pageable,searchCondition);
        for (CarEntity entity : carEntities){
            CarDto carData = CarDto.builder()
                    .carIdx(entity.getCarIdx())
                    .carNumber(entity.getCarNumber() != null ? entity.getCarNumber() : null)
                    .memberCarid(entity.getMemberCarid() != null ? entity.getMemberCarid() : null)
                    .empCarid(entity.getEmpCarid() != null ? entity.getEmpCarid() : null)
                    .carDivisionId(entity.getCarDivisionId() != null ? entity.getCarDivisionId() : null)
                    .carPhone(entity.getCarPhone() != null ? entity.getCarPhone() : null)
                    .carEnrolldate(entity.getCarEnrolldate() != null ? entity.getCarEnrolldate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null)
                    .carType(entity.getCarType() != null ?  entity.getCarType() : null)
                    .carNote(entity.getCarNote() != null ? entity.getCarNote() : null)
                    .carStartdate(entity.getCarStartdate() != null ? entity.getCarStartdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null)
                    .carEnddate(entity.getCarEnddate() != null ? entity.getCarEnddate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null)
                    .build();
            carList.add(carData);
        }
        Pagination pagination = new Pagination(
                (int) carEntities.getTotalPages(),pageable.getPageNumber()+1,pageable.getPageSize(),10
        );
        return  Header.OK(carList,pagination);
    }

    public CarDto getCar(Long id) {
        CarEntity entity = carRepository.findById(id).orElseThrow(() -> new RuntimeException("등록된 차량을 찾을 수 없습니다."));
        return CarDto.builder()
                .carIdx(entity.getCarIdx())
                .carNumber(entity.getCarNumber() != null ? entity.getCarNumber() : null)
                .memberCarid(entity.getMemberCarid() != null ? entity.getMemberCarid() : null)
                .empCarid(entity.getEmpCarid() != null ? entity.getEmpCarid() : null)
                .carDivisionId(entity.getCarDivisionId() != null ? entity.getCarDivisionId() : null)
                .carPhone(entity.getCarPhone() != null ? entity.getCarPhone() : null)
                .carEnrolldate(entity.getCarEnrolldate() != null ? entity.getCarEnrolldate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null)
                .carType(entity.getCarType() != null ? entity.getCarType() : null)
                .carNote(entity.getCarNote() != null ? entity.getCarNote() : null)
                .carEnddate(entity.getCarEnddate() != null ?  entity.getCarEnddate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null)
                .carStartdate(entity.getCarStartdate() != null ? entity.getCarStartdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null)
                .build();

    }

//    public CarEntity createCar(CarDto carDto) {
//        CarEntity entity = CarEntity.builder()
//                .carNumber(carDto.getCarNumber()!= null && !carDto.getCarNumber().isEmpty() ? carDto.getCarNumber() : null)
//                .memberCarid(carDto.getMemberCarid() != null ? carDto.getMemberCarid() : null)
//                .empCarid(carDto.getEmpCarid() != null ? carDto.getEmpCarid() : null)
//                .carDivisionId(carDto.getCarDivisionId() != null && !carDto.getCarDivisionId().isEmpty() ? carDto.getCarDivisionId() : null)
//                .carPhone(carDto.getCarPhone() != null && !carDto.getCarPhone().isEmpty() ? carDto.getCarPhone() : null)
//                .carEnrolldate(LocalDate.now())
//                .carType(carDto.getCarType() != null && !carDto.getCarType().isEmpty() ?  carDto.getCarType() : null)
//                .carNote(carDto.getCarNote() != null && !carDto.getCarNote().isEmpty() ?  carDto.getCarNote() : null)
//                .build();
//        return carRepository.save(entity);
//    }

    public CarEntity updateCar(CarDto carDto) {
        CarEntity entity = carRepository.findById(carDto.getCarIdx()).orElseThrow(() -> new RuntimeException("직원 정보를 찾을 수 없습니다."));
        EmpEntity empEntity = empRepository.findByEmpIdx(carDto.getEmpCarid().getEmpIdx());
        MemberEntity memberEntity = memberRepository.findByMemberidx(carDto.getMemberCarid().getMemberidx());

        entity.setEmpCarid(empEntity);
        entity.setMemberCarid(memberEntity);
        entity.setCarNumber(carDto.getCarNumber());
        entity.setCarDivisionId(carDto.getCarDivisionId());
        entity.setCarPhone(carDto.getCarPhone());
        entity.setCarType(carDto.getCarType());
        entity.setCarNote(carDto.getCarNote());
        entity.setCarEnddate(LocalDate.now());
        if(carDto.getCarStartdate() != null){
            entity.setCarStartdate(LocalDate.parse(carDto.getCarStartdate()));
        }else {
            entity.setCarStartdate(null);
        }
        if(carDto.getCarEnddate() != null){
            entity.setCarEnddate(LocalDate.parse(carDto.getCarEnddate()));
        }else {
            entity.setCarEnddate(null);
        }


        return carRepository.save(entity);
    }

    public void deleteCar(Long id) {
        CarEntity entity = carRepository.findById(id).orElseThrow(() -> new RuntimeException("차량 정보를 찾을 수 없습니다."));
        carRepository.delete(entity);

    }

    public Header<List<MemberDto>> getMember() {
        List<MemberDto> memberDtos = new ArrayList<>();
        List<MemberEntity> memberEntities = memberRepository.findAll();
        for(MemberEntity entity : memberEntities){
            MemberDto memberDto = MemberDto.builder()
                    .memberidx(entity.getMemberidx())
                    .memberdong(entity.getMemberdong() != null ? entity.getMemberdong() : null)
                    .memberho(entity.getMemberho() != null ? entity.getMemberho() : null)
                    .membername(entity.getMembername() != null ? entity.getMembername() : null)
                    .memberid(entity.getMemberid() != null ? entity.getMemberid() : null)
                    .memberloginok(entity.getMemberloginok() != null ? entity.getMemberloginok() : null)
                    .aptidx(entity.getAptidx())
                    .build();

            memberDtos.add(memberDto);
        }
        return Header.OK(memberDtos);
    }

    public Header<List<EmpDto>> getEmp() {
        List<EmpDto> empDtos = new ArrayList<>();
        List<EmpEntity> empEntities = empRepository.findAll();
        for(EmpEntity entity : empEntities){
            EmpDto empDto = EmpDto.builder()
                    .empIdx(entity.getEmpIdx())
                    .empId(entity.getEmpId() != null ? entity.getEmpId() : null)
                    .empPermanentId(entity.getEmpPermanentId() != null ? entity.getEmpPermanentId() : null)
                    .empJobId(entity.getEmpJobId() != null ? entity.getEmpJobId() : null)
                    .empDepartmentId(entity.getEmpDepartmentId() != null ? entity.getEmpDepartmentId() :  null)
                    .empName(entity.getEmpName() != null ? entity.getEmpName() : null)
                    .empPhone(entity.getEmpPhone() != null ? entity.getEmpPhone() : null)
                    .empHireDate(entity.getEmpHireDate() != null ? entity.getEmpHireDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null)
                    .empDepartureDate(entity.getEmpDepartureDate() != null ? entity.getEmpDepartureDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) :null)
                    .empCar(entity.getEmpCar() != null ? entity.getEmpCar() : null)
                    .empMemo(entity.getEmpMemo() != null ? entity.getEmpMemo() : null)
                    .empAuth(entity.getEmpAuth() != null ? entity.getEmpAuth() : null)
                    .build();
            empDtos.add(empDto);
        }
        return Header.OK(empDtos);
    }

    public CarEntity createCarEmp(CarDto carDto) {
        EmpEntity empEntity = empRepository.findByEmpIdx(carDto.getEmpCarid().getEmpIdx());
        MemberEntity memberEntity = memberRepository.findByMemberidx(carDto.getMemberCarid().getMemberidx());
        LocalDate carStartdate = null;
        LocalDate carEnddate = null;
        if (carDto.getCarStartdate() != null && !carDto.getCarStartdate().isEmpty()) {
            carStartdate = LocalDate.parse(carDto.getCarStartdate());
        }
        if(carDto.getCarEnddate() != null && !carDto.getCarEnddate().isEmpty()){
            carEnddate = LocalDate.parse(carDto.getCarEnddate());
        }
        CarEntity entity = CarEntity.builder()
                .carNumber(carDto.getCarNumber()!= null && !carDto.getCarNumber().isEmpty() ? carDto.getCarNumber() : null)
                .memberCarid(memberEntity)
                .empCarid(empEntity)
                .carDivisionId(carDto.getCarDivisionId() != null && !carDto.getCarDivisionId().isEmpty() ? carDto.getCarDivisionId() : null)
                .carPhone(carDto.getCarPhone() != null && !carDto.getCarPhone().isEmpty() ? carDto.getCarPhone() : null)
                .carEnrolldate(LocalDate.now())
                .carType(carDto.getCarType() != null && !carDto.getCarType().isEmpty() ?  carDto.getCarType() : null)
                .carNote(carDto.getCarNote() != null && !carDto.getCarNote().isEmpty() ?  carDto.getCarNote() : null)
                .carStartdate(carStartdate)
                .carEnddate(carEnddate)
                .build();
        return carRepository.save(entity);
    }
}
