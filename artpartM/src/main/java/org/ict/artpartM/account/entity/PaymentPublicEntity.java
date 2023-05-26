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
@Table(name = "PAYMENT_PUBLIC")
@Entity
@Builder
public class PaymentPublicEntity {
    @Id
    @GeneratedValue(generator = "PPIDX")
    @Column(name = "PPIDX")
    private long PPIdx;
    @Column(name = "PPDATE")
    private LocalDate PPDate;
    @Column(name = "PPFEE")
    private long PPFee;
}
