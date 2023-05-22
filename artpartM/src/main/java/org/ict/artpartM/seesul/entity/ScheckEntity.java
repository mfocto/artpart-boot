package org.ict.artpartM.seesul.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "SCHECK")
@Entity
public class ScheckEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHECKIDX")
    @SequenceGenerator(name="SCHECKIDX", sequenceName = "SCHECK_IDX", allocationSize=1)
    @Column(name = "SCHECKIDX")
    private long scheckidx;
    @ManyToOne
    @JoinColumn(name = "SIDX")
    private SeesulEntity sidx;
    @Column(name = "SCHECK")
    private long scheck;
    @Column(name = "SRESULT")
    private String sresult;
    @Column(name = "SPROCESS")
    private String sprocess;
}
