package org.ict.artpartM.car.model.dto;

import lombok.*;
import org.ict.artpartM.emp.entity.EmpEntity;
import org.ict.artpartM.member.entity.MemberEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {

    private Long carIdx;                //차량 등록 번호(CAR_IDX)(car_idx)
    private String carNumber;           //차량 번호(CAR_NUMBER)(car_number)
    private MemberEntity memberCarid;                  //입주민번호(MEMBER_CARID)(member_carid)
    private EmpEntity empCarid;              //사원 번호(사번)(EMP_CARID)(emp_carid)
    private String carDivisionId;       //차량 구분(방문차량 & 입주민 & 직원)(CAR_DIVISION_ID)(car_division_id)
    private String carPhone;            //차량 주인 전화 번호(CAR_PHONE)(car_phone)
    private String carEnrolldate;       //차량 등록 일시//LocalDateTime (CAR_ENROLLDATE)(car_enrolldate)
    private String carType;             //차종(CAR_TYPE)(car_type)
    private String carNote;             //비고(CAR_NOTE)(car_note)
    private String carStartdate;        //방문 시작 날짜(CAR_STARTDATE)(car_startdate)
    private String carEnddate;          //방문 종료 날짜(CAR_ENDDATE)(car_enddate)

}
