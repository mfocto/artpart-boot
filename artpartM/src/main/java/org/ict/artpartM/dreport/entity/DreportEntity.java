package org.ict.artpartM.dreport.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TRIAL_DAILY")
@Builder
public class DreportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRIAL_DAILY_IDX")
    private long trialDailyIdx;
    @Column(name = "TRIAL_DAILY_DATE")
    private LocalDateTime trialDailyDate;
    @PrePersist
    public void setTrialDailyDate() {
        trialDailyDate = LocalDateTime.now();
    }
    @Column(name = "TRIAL_DAILY_DEBITIN")
    private long trialDailyDebitIn;
    @Column(name = "TRIAL_DAILY_DEBITOUT")
    private long trialDailyDebitOut;
    @Column(name = "TRIAL_DAILY_DEBITTOTAL")
    private long trialDailyDebitTotal;
    @Column(name = "TRIAL_DAILY_CREDITIN")
    private long trialDailyCreditIn;
    @Column(name = "TRIAL_DAILY_CREDITOUT")
    private long trialDailyCreditOut;
    @Column(name = "TRIAL_DAILY_CREDITTOTAL")
    private long trialDailyCreditTotal;
    @Column(name = "TRIAL_DAILY_ACCOUNT")
    private String trialDailyAccount;
}
