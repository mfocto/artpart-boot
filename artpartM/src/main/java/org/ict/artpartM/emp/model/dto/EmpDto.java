package org.ict.artpartM.emp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpDto {
    private int empIdx;
    private String empId;
    private String empPermanentId;
    private String empJobId;
    private String empDepartmentId;
    private String empName;
    private String empEmail;
    private String empPwd;
    private String empAddress;
    private String empPhone;
    private String empHireDate;
    private String empDepartureDate;
    private String empCar;
    private String empImg;
    private String empImgUp;
}
