package org.ict.artpartM.member.entity;


import com.sun.istack.NotNull;
import lombok.*;


import javax.persistence.*;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="MINONE")
@Entity
public class MinoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MIN_IDX")
    @SequenceGenerator(name="MIN_IDX", sequenceName = "MIN_IDX" , allocationSize = 1)
    @Column(name="MIN_IDX")
    private long minidx;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "MEMBER_IDX")
    private MemberEntity memberidx;
    @NotNull
    @Column(name= "MIN_TITLE")
    private String mintitle;
    @NotNull
    @Column(name = "MIN_TYPE")
    private String mintype;
    @NotNull
    @Column(name = "MIN_STATUS", columnDefinition = "String default '처리예정'")
    private String minstatus;
    @Column(name = "MIN_RES")
    private String minres;
    @Column(name = "MIN_FILE")
    private String minfile;
    @Column(name = "MIN_RENAME")
    private String minrename;
    @NotNull
    @Column(name = "MIN_CATEGORY")
    private String mincategory;
}
