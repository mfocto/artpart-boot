package org.ict.artpart.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "MEMBER")
@Entity
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_IDX")
    private long memberIdx;

    @Column(name = "MEMBER_ADD")
    private String memberAdd;

    @Column(name="MEMBER_DONG")
    private String memberDong;

    @Column(name= "MEMBER_HO")
    private String memberHo;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "MEMBER_ID")
    private String memberId;

    @Column(name = "MEMBER_PASSWORD")
    private String memberPw;

    @Column(name = "MEMBER_PHONE")
    private String memberPhone;

    @Column(name = "MEMBER_LOGINOK")
    private String memberLoginOK;
}
