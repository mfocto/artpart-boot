package org.ict.artpartM.car.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.car.entity.CarEntity;
import org.ict.artpartM.car.model.dto.CarDto;
import org.ict.artpartM.car.model.service.CarService;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.SearchCondition;
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

    @PostMapping("/car")//creat == postMapping
    public CarEntity createCar(@RequestBody CarDto carDto){
        return carService.createCar(carDto);
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
