package org.ict.artpartM.account.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.artpartM.member.entity.MemberEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAYMENT_MEMBER")
@Entity
@Builder
public class PaymentMemberEntity {
    @Id
    @GeneratedValue(generator = "PMIDX")
    private long PMIdx;
    @ManyToOne
    @JoinColumn(name = "MEMBER_NO")
    private MemberEntity memberNo;
    @Column(name = "PMDATE")
    private LocalDate PMDate;
    @Column(name = "PMHEAT")
    private long PMHeat;
    @Column(name = "PMONSU")
    private long PMOnsu;
    @Column(name = "PMGAS")
    private long PMGas;
    @Column(name = "PMELEC")
    private long PMElec;
    @Column(name = "PMWATER")
    private long PMWater;
    @Column(name = "PMSEPTIC")
    private long PMSeptic;
    @Column(name = "PMWASTE")
    private long PMWaste;
    @Column(name = "PMOPERCOST")
    private long PMOpercost;
    @Column(name = "PMINSURE")
    private long PMInsure;
}
