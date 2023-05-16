package org.ict.artpart.using.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.ict.artpart.member.entity.MemberEntity;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PAYMENT_DETAILS")
@Entity
public class UsingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DETAIL_IDX")
    @SequenceGenerator(name = "DETAIL_IDX", sequenceName = "DETAIL_IDX", allocationSize = 1)
    @Comment("관리비 번호")
    @Column(name = "DETAIL_IDX")
    private long detailIdx;

    @ManyToOne
    @Comment("입주민 번호")
    @JoinColumn(name = "MEMBER_IDX")
    private MemberEntity memberIdx;

    @Comment("결제일자")
    @Column(name = "PAYMENT_DATE")
    private Date paymentDate;

    @Comment("납부 마감일")
    @Column(name = "PAYMENT_DADLINE", nullable = false)
    private Date paymentDadLine;

    @Comment("결제 금액")
    @Column(name = "PAYMENT_MONEY" , nullable = false)
    private int paymentMoney;

    @Comment("금융사")
    @Column(name = "PAYMENT_BANK", nullable = false)
    private String paymentBank;

    @Comment("납부 계좌번호")
    @Column(name = "BANK_NUMBER", nullable = false)
    private String bankNumber;

    @Comment("진행 상태")
    @Column(name = "PAYMENT_STATUS", nullable = false)
    private String paymentStatus;

}
