package org.ict.artpartM.company.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "COMPANY")
@Entity
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANYIDX")
    @SequenceGenerator(name="COMPANYIDX", sequenceName = "COMPANY_IDX", allocationSize=1)
    @Column(name = "COMPANYIDX")
    private long companyidx;
    @Column(name="NAME")
    private String name;
    @Column(name = "ITEM")
    private String item;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "COMPANYDATE", columnDefinition = "date default sysdate")
    private LocalDate companydate;
}
