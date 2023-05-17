package org.ict.artpart.emp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
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
    @Comment("직원등록 번호")
    private int empIdx;

    @Column(name = "EMP_ID", nullable = false)
    @Comment("직원아이디")
    private String empId;

    @Column(name = "EMP_PERMANENTID")
    @Comment("사원 구분")
    private String empPermanentId;

    @Column(name = "EMP_DEPARTMENTID")
    @Comment("직급")
    private String empDepartmentId;

    @Column(name = "EMP_JOBID")
    @Comment("소속")
    private String empJobId;

    @Column(name = "EMP_NAME", nullable = false)
    @Comment("사원명")
    private String empName;

    @Column(name = "EMP_EMAIL")
    @Comment("이메일 주소")
    private String empEmail;

    @Column(name = "EMP_PWD", nullable = false)
    @Comment("비밀번호")
    private String empPwd;

    @Column(name = "EMP_ADDRESS", nullable = false)
    @Comment("주소")
    private String empAddress;

    @Column(name = "EMP_PHONE", nullable = false)
    @Comment("연락처")
    private String empPhone;

    @Column(name = "EMP_HIREDATE", nullable = false)
    @Comment("입사일")
    private LocalDateTime empHireDate;

    @Column(name = "EMP_DEPARTUREDATE")
    @Comment("퇴사일")
    private LocalDateTime empDepartureDate;

    @Column(name = "EMP_CAR")
    @Comment("차량번호")
    private String empCar;

    @Column(name = "EMP_IMG")
    @Comment("사진")
    private String empImg;

    @Column(name = "EMP_IMG_UP")
    @Comment("사진(수정)")
    private String empImgUp;
}
