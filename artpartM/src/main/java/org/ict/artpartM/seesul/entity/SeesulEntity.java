package org.ict.artpartM.seesul.entity;

import lombok.*;
import org.ict.artpartM.emp.entity.EmpEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "SEESUL")
@Entity
public class SeesulEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SIDX")
    @SequenceGenerator(name="SIDX", sequenceName = "S_IDX", allocationSize=1)
    @Column(name = "SIDX")
    private long sidx;
    @Column(name = "SCATEGORY")
    private String scategory;
    @Column(name = "SDATE", columnDefinition = "date default sysdate")
    private LocalDate sdate;
    @ManyToOne
    @JoinColumn(name = "SWIRITER")
    private EmpEntity swiriter;

}
