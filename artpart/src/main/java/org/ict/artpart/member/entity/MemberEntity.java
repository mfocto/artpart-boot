package org.ict.artpart.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.ict.artpart.apt.entity.AptEntity;


import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "MEMBER")
@Entity
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_IDX")
    @SequenceGenerator(name = "MEMBER_IDX", sequenceName = "MEMBER_IDX", allocationSize = 1)
    @Column(name = "MEMBER_IDX")
    @Comment("입주민 번호")
    private long memberIdx;

    @ManyToOne
    @Comment("아파트 번호")
    @JoinColumn(name = "APT_IDX")
    private AptEntity aptIdx;

    @Comment("동")
    @Column(name="MEMBER_DONG")
    private String memberDong;

    @Comment("호수")
    @Column(name="MEMBER_HO")
    private String memberHo;

    @Comment("이름")
    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Comment("아이디")
    @Column(name = "MEMBER_ID")
    private String memberId;

    @Comment("비밀번호")
    @Column(name = "MEMBER_PASSWORD")
    private String memberPassword;

    @Comment("전화번호")
    @Column(name = "MEMBER_PHONE")
    private String memberPhone;

    @Comment("입주완료여부")
    @Column(name = "MEMBER_LOGINOK")
    private String memberLoginOK;        //입주완료여부


    @Comment("등록차 번호1")
    @Column(name = "MEMBER_MYCAR1")
    private String memberMyCar1;

    @Comment("등록차 번호2")
    @Column(name = "MEMBER_MYCAR2")
    private String memberMyCar2;
}
