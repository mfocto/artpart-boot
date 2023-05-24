package org.ict.artpart.paymentmember.entity;

import lombok.*;
import org.hibernate.annotations.Comment;
import org.ict.artpart.member.entity.MemberEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PAYMENT_MEMBER")
public class PaymentMemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PMIDX" )
    @SequenceGenerator(name = "PMIDX", sequenceName = "PMIDX", allocationSize = 1)
    @Column(name = "PMIDX")
    @Comment("개별관리비번호")
    private long pmIdx;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NO" , referencedColumnName = "MEMBERIDX")
    @Comment("입주민번호")
    private MemberEntity memberNo;

    @Column(name = "PMDATE" , columnDefinition = "DATE")
    @Comment("일자")
    private Date pmDate;

    @Column(name = "PMHEAT")
    @Comment("난방비")
    private BigDecimal pmHeat;

    @Column(name = "PMONSU")
    @Comment("급탕비(온수)")
    private BigDecimal pmOnsu;

    @Column(name = "PMGAS")
    @Comment("가스사용")
    private BigDecimal pmGas;

    @Column(name = "PMELEC")
    @Comment("전기세")
    private BigDecimal pmElec;

    @Column(name = "PMWATER")
    @Comment("수도세")
    private BigDecimal pmWater;

    @Column(name = "PMSEPTIC")
    @Comment("정화조오물수수료")
    private BigDecimal pmSeptic;

    @Column(name = "PMWASTE")
    @Comment("생활폐기물수수료")
    private BigDecimal pmWaste;

    @Column(name = "PMOPERCOST")
    @Comment("관리위원회운영비")
    private BigDecimal pmOpercost;

    @Column(name = "PMINSURE")
    @Comment("건물보험료")
    private BigDecimal pmInsure;


    //
    public PaymentMemberEntity(Date pmDate, BigDecimal pmHeat) {
        this.pmDate = pmDate;
        this.pmHeat = pmHeat;
    }
    public PaymentMemberEntity(Date pmDate, BigDecimal pmHeat, BigDecimal pmOnsu, BigDecimal pmGas, BigDecimal pmElec,
                               BigDecimal pmWater, BigDecimal pmSeptic, BigDecimal pmWaste, BigDecimal pmOpercost, BigDecimal pmInsure) {
        this.pmDate = pmDate;
        this.pmHeat = pmHeat;
        this.pmOnsu = pmOnsu;
        this.pmGas = pmGas;
        this.pmElec = pmElec;
        this.pmWater = pmWater;
        this.pmSeptic = pmSeptic;
        this.pmWaste = pmWaste;
        this.pmOpercost = pmOpercost;
        this.pmInsure = pmInsure;


    }
}
