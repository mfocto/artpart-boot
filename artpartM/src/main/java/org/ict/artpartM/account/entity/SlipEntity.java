package org.ict.artpartM.account.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SLIP")
@Builder
public class SlipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SLIPIDX")
    @SequenceGenerator(name = "SLIPIDX", sequenceName = "SLIPIDX", allocationSize = 1)
    @Column(name = "SLIPIDX")
    private long slipIdx;
    @Column(name = "SLIPDATE")
    private LocalDate slipDate;
    @PrePersist
    public void setSlipDate(){
        this.slipDate = LocalDate.now();
    }
    @Column(name = "SLIPNO")
    private String slipNo;
    @Column(name = "SLIPTYPE")
    private String slipType;
    @Column(name = "SLIPITEM")
    private String slipItem;
    @Column(name = "SLIPCOMP")
    private String slipComp;
    @Column(name = "SLIPBRIF")
    private String slipBrif;
    @Column(name = "SLIPCASH")
    private long slipCash;
    @Column(name = "SLIPNOTE")
    private String slipNote;
    @Column(name="SLIPWRITER")
    private String slipWriter;
}
