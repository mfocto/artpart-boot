package org.ict.artpartM.car.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="CAR")
@Entity
public class CarEntity {

    @Id
    @Column(name="CAR_NUMBER")
    private String carNumber;           //차량 번호(car_number)
    @Column(name="MEMBER_IDX")
    private long mIdx;                  //입주민번호(member_idx)
    @Column(name="EMP_ID_CAR")
    private String empCar;              //사원 번호(사번)(emp_id_car)
    @Column(name="CAR_DIVISION_ID")
    private String carDivisionId;       //차량 구분(방문차량 & 입주민 & 직원)(car_division_id)
    @Column(name="CAR_PHONE")
    private String carPhone;            //차량 주인 전화 번호(car_phone)
    @Column(name="CAR_ENROLLDATE")
    private LocalDateTime carEnrollDate;       //차량 등록 일시(car_enrolldate)
    @Column(name="CAR_CHANGEDATE")
    private LocalDateTime carChangeDate;       //차량 수정 일시(car_changedate)
    @Column(name="CAR_TYPE")
    private String carType;             //차종(car_type)
    @Column(name="CAR_NOTE")
    private String carNote;             //비고(car_note)
    @Column(name="CAR_STARTDATE")
    private LocalDateTime carStartDate;        //방문 시작 날짜(car_startdate)
    @Column(name="CAR_ENDDATE")
    private LocalDateTime carEndDate;          //방문 종료 날짜(car_enddate)
}
