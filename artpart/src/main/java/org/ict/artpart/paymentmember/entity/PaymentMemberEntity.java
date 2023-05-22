package org.ict.artpart.paymentmember.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.ict.artpart.member.entity.MemberEntity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

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

    @Column(name = "PMDATE")
    @Comment("일자")
    private LocalDateTime pmDate;

    @Column(name = "PMHEAT")
    @Comment("난방비")
    private int pmHeat;

    @Column(name = "PMONSU")
    @Comment("급탕비(온수)")
    private int pmOnsu;

    @Column(name = "PMGAS")
    @Comment("가스사용")
    private int pmGas;

    @Column(name = "PMELEC")
    @Comment("전기세")
    private int pmElec;

    @Column(name = "PMWATER")
    @Comment("수도세")
    private int pmWater;

    @Column(name = "PMSEPTIC")
    @Comment("정화조오물수수료")
    private int pmSeptic;

    @Column(name = "PMWASTE")
    @Comment("생활폐기물수수료")
    private int pmWaste;

    @Column(name = "PMOPERCOST")
    @Comment("관리위원회운영비")
    private int pmOpercost;

    @Column(name = "PMINSURE")
    @Comment("건물보험료")
    private int pmInsure;




}
