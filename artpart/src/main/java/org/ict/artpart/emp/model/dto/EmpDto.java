package org.ict.artpart.emp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpDto {
    private int empIdx;                 //직원등록 번호
    private String empId;               //직원 아이디
    private String empPermanentId;      //사원 구분
    private String empDepartmentId;     //직급
    private String empJobId;            //소속
    private String empName;             //사원명
    private String empEmail;            //이메일 주소
    private String empPwd;              //비밀번호
    private String empAddress;          //주소
    private String empPhone;            //연락처
    private String empHireDate;         //입사일
    private String empDepartureDate;    //퇴사일
    private String empCar;              //차량 번호
    private String empImg;              //사진
    private String empImgUp;            //사진(수정)
}
