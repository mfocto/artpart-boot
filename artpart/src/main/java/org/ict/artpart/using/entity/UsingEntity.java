package org.ict.artpart.using.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @Column(name = "DETAIL_IDX")
    private long detailIdx;

    @ManyToOne
    @JoinColumn(name = "MEMBER_IDX")
    private MemberEntity memberIdx;

    @Column(name = "PAYMENT_DATE")
    private Date paymentDate;

    @Column(name = "PAYMENT_DADLINE")
    private Date paymentDadLine;

    @Column(name = "PAYMENT_MONEY")
    private String paymentMoney;

    @Column(name = "PAYMENT_BANK")
    private String paymentBank;

    @Column(name = "BANK_NUMBER")
    private String bankNumber;

    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;

}
