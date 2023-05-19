package org.ict.artpartM.company.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDto {
    private long companyidx;
    private String name;
    private String item;
    private String phone;
    private String address;
    private String companydate;
}
