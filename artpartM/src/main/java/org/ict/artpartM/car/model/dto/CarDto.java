package org.ict.artpartM.car.model.dto;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {

    private String carNumber;           //차량 번호(car_number)
    private long mIdx;                  //입주민번호(member_idx)
    private String empCar;              //사원 번호(사번)(emp_id_car)
    private String carDivisionId;       //차량 구분(방문차량 & 입주민 & 직원)(car_division_id)
    private String carPhone;            //차량 주인 전화 번호(car_phone)
    private String carEnrollDate;       //차량 등록 일시(car_enrolldate)
    private String carChangeDate;       //차량 수정 일시(car_changedate)
    private String carType;             //차종(car_type)
    private String carNote;             //비고(car_note)
    private String carStartDate;        //방문 시작 날짜(car_startdate)
    private String carEndDate;          //방문 종료 날짜(car_enddate)

}
