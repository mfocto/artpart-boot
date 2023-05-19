package org.ict.artpartM.member.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.ict.artpartM.apt.entity.AptEntity;

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
    @ManyToOne
    @JoinColumn(name = "APTIDX")
    private AptEntity aptidx;
    @NotNull
    @Column(name= "MEMBERDONG")
    private String memberdong;
    @NotNull
    @Column(name = "MEMBERHO")
    private String memberho;
    @Column(name = "MEMBERNAME")
    private String membername;
    @Column(name = "MEMBERID")
    private String memberid;
    @Column(name = "MEMBERPASSWORD")
    private String memberpassword;
    @Column(name = "MEMBERPHONE")
    private String memberphone;
    @NotNull
    @Column(name = "MEMBERLOGINOK", columnDefinition = "char default 'N'")
    private String memberloginok;
    @Column(name = "MEMBERMYCAR1")
    private String membermycar1;
    @Column(name = "MEMBERMYCAR2")
    private String membermycar2;



}
