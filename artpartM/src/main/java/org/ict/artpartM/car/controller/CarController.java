package org.ict.artpartM.car.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.car.entity.CarEntity;
import org.ict.artpartM.car.model.dto.CarDto;
import org.ict.artpartM.car.model.service.CarService;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.emp.model.dto.EmpDto;
import org.ict.artpartM.member.model.dto.MemberDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class CarController {
    private  final CarService carService;


    //차량 정보 전체 출력
    @GetMapping("/car/list")
    public Header<List<CarDto>> getCarList(@PageableDefault(sort = {"car_idx"}) Pageable pageable, SearchCondition searchCondition){
        return  carService.getCarList(pageable,searchCondition);
    }

    //차량 한개 출력
    @GetMapping("/car/{id}")
    public CarDto getCar(@PathVariable Long id){
        return carService.getCar(id);
    }
    //입주민리스트 갖고 오기
    @GetMapping("/memberForCar/list")
    public Header<List<MemberDto>> getMember(){
        return carService.getMember();
    }
    @GetMapping("/empForCar/list")
    public Header<List<EmpDto>> getEmp(){
        return carService.getEmp();
    }

    //차량 등록(처음)
//    @PostMapping("/car/{member_carid}")//creat == postMapping
//    public CarEntity createCarMember(@RequestBody CarDto carDto,@PathVariable long member_carid){
//        log.info(String.valueOf(member_carid));
//        log.info(carDto.toString());
//        return carService.createCarMember(carDto,member_carid);
//    }
//    @PostMapping("/car/{emp_carid}")//creat == postMapping
//    public CarEntity createCarEmp(@RequestBody CarDto carDto,@PathVariable long emp_carid){
//        log.info(String.valueOf(emp_carid));
//        log.info(carDto.toString());
//        return carService.createCarEmp(carDto,emp_carid);
//    }

    @PostMapping("/car")
    public CarEntity create(@RequestBody CarDto carDto){
        log.info("obj : " + carDto);
        return carService.createCarEmp(carDto);
    }
    @PatchMapping("/car")
    public CarEntity updateCar(@RequestBody CarDto carDto){
        return carService.updateCar(carDto);
    }

    @DeleteMapping("/car/{id}")
    public void deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
    }



}
