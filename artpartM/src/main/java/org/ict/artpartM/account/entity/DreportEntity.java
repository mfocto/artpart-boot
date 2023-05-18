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
@Table(name = "TRIAL_DAILY")
@Builder
public class DreportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TDIDX")
    @SequenceGenerator(name = "TDIDX", sequenceName = "TDIDX", allocationSize = 1)
    @Column(name = "TDIDX")
    private long TDIdx;
    @Column(name = "TDDATE")
    private LocalDate TDDate;
    @PrePersist
    public void setTrialDailyDate() {
        TDDate = LocalDate.now();
    }
    @Column(name = "TDDEBITIN")
    private long TDDebitIn;
    @Column(name = "TDDEBITOUT")
    private long TDDebitOut;
    @Column(name = "TDDEBITTOTAL")
    private long TDDebitTotal;
    @Column(name = "TDCREDITIN")
    private long TDCreditIn;
    @Column(name = "TDCREDITOUT")
    private long TDCreditOut;
    @Column(name = "TDCREDITTOTAL")
    private long TDCreditTotal;
    @Column(name = "TDACCOUNT")
    private String TDAccount;
}
