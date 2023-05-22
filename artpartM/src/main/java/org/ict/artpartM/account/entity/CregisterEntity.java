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
@Table(name="CASH_REGISTER")
@Builder
public class CregisterEntity {
    @Id
    @GeneratedValue(generator = "CRIDX")
    @SequenceGenerator(name="CRIDX", sequenceName = "CRIDX", allocationSize = 1)
    @Column(name="CRIDX")
    private long crIdx;
    @Column(name="CRDATE")
    private LocalDate crDate;
    @PrePersist
    public void setDate(){
        this.crDate = LocalDate.now();
    }
    @Column(name="CRBRIF")
    private String crBrif;
    @Column(name="CRIN")
    private long crIn;
    @Column(name="CROUT")
    private long crOut;
    @Column(name="CRCASH")
    private long crCash;
    @Column(name="CRNOTE")
    private String crNote;
    @Column(name="CRWRITER")
    private String crWriter;
}
