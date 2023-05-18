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
@Table(name = "TRIAL_MONTHLY")
@Entity
@Builder
public class MreportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TMIDX")
    @SequenceGenerator(name = "TMIDX", sequenceName = "TMIDX", allocationSize = 1)
    @Column(name = "TMIDX")
    private long TMIdx;
    @Column(name = "TMDATE")
    private LocalDate TMDate;
    @PrePersist
    public void setTrialMonthlyDate() {
        TMDate = LocalDate.now();
    }
    @Column(name = "TMDEBITIN")
    private long TMDebitIn;
    @Column(name = "TMDEBITOUT")
    private long TMDebitOut;
    @Column(name = "TMDEBITTOTAL")
    private long TMDebitTotal;
    @Column(name = "TMCREDITIN")
    private long TMCreditIn;
    @Column(name = "TMCREDITOUT")
    private long TMCreditOut;
    @Column(name = "TMCREDITTOTAL")
    private long TMCreditTotal;
    @Column(name = "TMACCOUNT")
    private String TMAccount;
}
