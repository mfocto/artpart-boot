package org.ict.artpartM.car.entity;

import lombok.*;
import org.ict.artpartM.emp.entity.EmpEntity;
import org.ict.artpartM.member.entity.MemberEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Table(name="CAR")
@Entity
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_IDX")
    @SequenceGenerator(name="CAR_IDX", sequenceName = "CAR_IDX", allocationSize=1)
    @Column(name = "CAR_IDX")
    private long carIdx;                //차량 등록 번호(CAR_IDX)(car_idx)
    @Column(name="CAR_NUMBER")
    private String carNumber;           //차량 번호(CAR_NUMBER)(car_number)
    @ManyToOne
    @JoinColumn(name = "MEMBER_CARID")
    private MemberEntity memberCarid;                  //입주민번호(MEMBER_CARID)(member_carid)
    @ManyToOne
    @JoinColumn(name="EMP_CARID")
    private EmpEntity empCarid;              //사원 번호(사번)(EMP_CARID)(emp_carid)
    @Column(name="CAR_DIVISION_ID")
    private String carDivisionId;       //차량 구분(방문차량 & 입주민 & 직원)(CAR_DIVISION_ID)(car_division_id)
    @Column(name="CAR_PHONE")
    private String carPhone;            //차량 주인 전화 번호(CAR_PHONE)(car_phone)
    @Column(name="CAR_ENROLLDATE", columnDefinition = "date default sysdate")
    private LocalDateTime carEnrolldate;       //차량 등록 일시(CAR_ENROLLDATE)(car_enrolldate)
    @Column(name="CAR_TYPE")
    private String carType;             //차종(CAR_TYPE)(car_type)
    @Column(name="CAR_NOTE")
    private String carNote;             //비고(CAR_NOTE)(car_note)
    @Column(name="CAR_STARTDATE")
    private LocalDateTime carStartdate;        //방문 시작 날짜(CAR_STARTDATE)(car_startdate)
    @Column(name="CAR_ENDDATE")
    private LocalDateTime carEnddate;          //방문 종료 날짜(CAR_ENDDATE)(car_enddate)

}
