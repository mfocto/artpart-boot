package org.ict.artpartM.emp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPIDX")
    @Column(name = "EMP_IDX")
    private int empIdx;
    @Column(name = "EMP_ID")
    private String empId;
    @Column(name = "EMP_PERMANENTID")
    private String empPermanentId;
    @Column(name = "EMP_JOBID")
    private String empJobId;
    @Column(name = "EMP_DEPARTMENTID")
    private String empDepartmentId;
    @Column(name = "EMP_NAME")
    private String empName;
    @Column(name = "EMP_EMAIL")
    private String empEmail;
    @Column(name = "EMP_PWD")
    private String empPwd;
    @Column(name = "EMP_ADDRESS")
    private String empAddress;
    @Column(name = "EMP_PHONE")
    private String empPhone;
    @Column(name = "EMP_HIREDATE")
    private LocalDateTime empHireDate;
    @Column(name = "EMP_DEPARTUREDATE")
    private LocalDateTime empDepartureDate;
    @Column(name = "EMP_CAR")
    private String empCar;
    @Column(name = "EMP_IMG")
    private String empImg;
    @Column(name = "EMP_IMG_UP")
    private String empImgUp;
}
