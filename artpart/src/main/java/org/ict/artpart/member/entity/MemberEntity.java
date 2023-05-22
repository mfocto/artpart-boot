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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBERIDX")
    @SequenceGenerator(name = "MEMBERIDX", sequenceName = "MEMBERIDX", allocationSize = 1)
    @Column(name = "MEMBERIDX")
    private Long memberIdx;

    @ManyToOne
    @JoinColumn(name = "APTIDX")
    private AptEntity aptIdx;

    @Column(name="MEMBERDONG")
    private String memberDong;

    @Column(name="MEMBERHO")
    private String memberHo;

    @Column(name = "MEMBERNAME")
    private String memberName;

    @Column(name = "MEMBERID")
    private String memberId;

    @Column(name = "MEMBERPASSWORD")
    private String memberPassword;

    @Column(name = "MEMBERPHONE")
    private String memberPhone;

    @Column(name = "MEMBERLOGINOK")
    private String memberLoginOK;

    @Column(name = "MEMBERMYCAR1")
    private String memberMyCar1;

    @Column(name = "MEMBERMYCAR2")
    private String memberMyCar2;

    @Column(name = "MEMBERAUTH")
    private String memberAuth;

}
