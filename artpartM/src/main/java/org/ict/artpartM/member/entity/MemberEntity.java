package org.ict.artpartM.member.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="MEMBER")
@Entity
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBERIDX")
    @SequenceGenerator(name="MEMBERIDX", sequenceName = "MEMBER_IDX" , allocationSize = 1)
    @Column(name="MEMBERIDX")
    private long memberidx;
//    @ManyToOne
//    @NotNull
//    @JoinColumn(name = "APT_IDX")
//    private AptEntity aptidx;
    @NotNull
    @Column(name= "MEMBER_DONG")
    private String memberdong;
    @NotNull
    @Column(name = "MEMBER_HO")
    private String memberho;
    @NotNull
    @Column(name = "MEMBER_NAME")
    private String membername;
    @Column(name = "MEMBER_ID")
    private String memberid;
    @Column(name = "MEMBER_PASSWORD")
    private String memberpassword;
    @NotNull
    @Column(name = "MEMBER_PHONE")
    private String memberphone;
    @NotNull
    @Column(name = "MEMBER_LOGINOK", columnDefinition = "String default 'N'")
    private String memberloginok;
    @Column(name = "MEMBER_MYCAR1")
    private String membermycar1;
    @Column(name = "MEMBER_MYCAR2")
    private String membermycar2;



}
