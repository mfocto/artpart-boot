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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Header<List<CarDto>> getCarList(Pageable pageable, SearchCondition searchCondition) {
        List<CarDto> carList = new ArrayList<>();

        Page<CarEntity> carEntities = carRepositoryCustom.findAllBySearchCondition(pageable,searchCondition);
        for (CarEntity entity : carEntities){
            CarDto carData = CarDto.builder()
                    .carIdx(entity.getCarIdx())
                    .carNumber(entity.getCarNumber())
                    .memberCarid(entity.getMemberCarid())
                    .empCarid(entity.getEmpCarid())
                    .carDivisionId(entity.getCarDivisionId())
                    .carPhone(entity.getCarPhone())
                    .carEnrolldate(String.valueOf(entity.getCarEnrolldate().toLocalDate()))
                    .carType(entity.getCarType())
                    .carNote(entity.getCarNote())
                    .carStartdate(String.valueOf(entity.getCarStartdate().toLocalDate()))
                    .carEnddate(String.valueOf(entity.getCarEnddate().toLocalDate()))
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
                .carNumber(entity.getCarNumber())
                .memberCarid(entity.getMemberCarid())
                .empCarid(entity.getEmpCarid())
                .carDivisionId(entity.getCarDivisionId())
                .carPhone(entity.getCarPhone())
                .carEnrolldate(entity.getCarEnrolldate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .carType(entity.getCarType())
                .carNote(entity.getCarNote())
                .carEnddate(entity.getCarEnddate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .carStartdate(entity.getCarStartdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .build();

    }

    public CarEntity createCar(CarDto carDto) {
        CarEntity entity = CarEntity.builder()
                .carNumber(carDto.getCarNumber())
                .memberCarid(carDto.getMemberCarid())
                .empCarid(carDto.getEmpCarid())
                .carDivisionId(carDto.getCarDivisionId())
                .carPhone(carDto.getCarPhone())
                .carEnrolldate(LocalDateTime.now())
                .carType(carDto.getCarType())
                .carNote(carDto.getCarNote())
                .carStartdate(LocalDateTime.parse(carDto.getCarStartdate()))
                .carEnddate(LocalDateTime.parse(carDto.getCarEnddate()))
                .build();
        return carRepository.save(entity);
    }

    public CarEntity updateCar(CarDto carDto) {
        CarEntity entity = carRepository.findByCarIdx(carDto.getCarIdx());

        entity.setCarNumber(carDto.getCarNumber());
        entity.setCarDivisionId(carDto.getCarDivisionId());
        entity.setCarPhone(carDto.getCarPhone());
        entity.setCarType(carDto.getCarType());
        entity.setCarNote(carDto.getCarNote());
        entity.setCarStartdate(LocalDateTime.parse(carDto.getCarStartdate()));
        entity.setCarEnddate(LocalDateTime.parse(carDto.getCarEnddate()));
        return carRepository.save(entity);
    }

    public void deleteCar(Long id) {
        CarEntity entity = carRepository.findById(id).orElseThrow(() -> new RuntimeException("차량 정보를 찾을 수 없습니다."));
        carRepository.delete(entity);

    }
}
