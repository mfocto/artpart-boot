package org.ict.artpartM.emp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "EMP")
@Entity
public class EmpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMP_IDX")
    @SequenceGenerator(name = "EMP_IDX", sequenceName = "EMP_IDX", allocationSize = 1)
    @Column(name = "EMP_IDX")
    private long empIdx;                        //직원등록번호(EMP_IDX)(emp_idx)
    @Column(name = "EMP_ID")
    private String empId;                       //직원 아디디(EMP_ID)(emp_id)
    @Column(name = "EMP_PERMANENTID")
    private String empPermanentId;              //사원 구분(EMP_PERMANENT_ID)(emp_permanent_id) (정규직 , 계약직, 알바)
    @Column(name = "EMP_JOBID")
    private String empJobId;                    //소속(EMP_JOB_ID)(emp_job_id)(반장, 소장, 기사, 사무원, 관리원, 미화원)
    @Column(name = "EMP_DEPARTMENTID")
    private String empDepartmentId;             //직급(EMP_DEPARTMENT_ID)(emp_department_id)(관리직-행정직, 관리직-경비직, 관리직-청소직, 기술직-전기, 기술직-설비, 기술직-열선)
    @Column(name = "EMP_NAME")
    private String empName;                     //사원명(EMP_NAME)(emp_name)
    @Column(name = "EMP_EMAIL")
    private String empEmail;                    //이메일 주소(EMP_EMAIL)(emp_email)
    @Column(name = "EMP_PWD")
    private String empPwd;                      //비밀번호(EMP_PWD)(emp_pwd)
    @Column(name = "EMP_ADDRESS")
    private String empAddress;                  //주소(EMP_ADDRESS)(emp_address)
    @Column(name = "EMP_PHONE")
    private String empPhone;                    //연락처(EMP_PHONE)(emp_phone)
    @Column(name = "EMP_HIREDATE")
    private LocalDateTime empHireDate;          //입사일(EMP_HIRE_DATE)(emp_hire_date)
    @Column(name = "EMP_DEPARTUREDATE")
    private LocalDateTime empDepartureDate;     //퇴사일(EMP_DEPARTURE_DATE)(emp_departure_date)
    @Column(name = "EMP_CAR")
    private String empCar;                      //차량번호(EMP_CAR)(emp_car)
    @Column(name = "EMP_IMG")
    private String empImg;                      //사진(EMP_IMG)(emp_img)
    @Column(name = "EMP_IMG_UP")
    private String empImgUp;                    //사진(수정)(EMP_IMG_UP)(emp_img_up)
    @Column(name="EMP_AUTH")
    private String empAuth;                     //권한(EMP_AUTH)(emp_auth)
    @Column(name="EMP_MEMO")
    private String empMemo;                     //비고(EMP_MEMO)(emp_memo)
}
