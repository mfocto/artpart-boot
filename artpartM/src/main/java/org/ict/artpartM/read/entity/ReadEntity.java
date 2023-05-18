package org.ict.artpartM.read.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.ict.artpartM.member.entity.MemberEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "READ")
@Entity
public class ReadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "READIDX")
    @SequenceGenerator(name="READIDX", sequenceName = "READ_IDX", allocationSize=1)
    @Column(name = "READIDX")
    private long readidx;
    @ManyToOne
    @JoinColumn(name = "memberidx")
    private MemberEntity memberidx;
    @NotNull
    @Column(name = "ELECTRIC")
    private long electric;
    @NotNull
    @Column(name = "HOTWATER")
    private long hotwater;
    @NotNull
    @Column(name = "WATER")
    private long water;
    @NotNull
    @Column(name = "HEAT")
    private long heat;
    @NotNull
    @Column(name = "READDATE")
    private LocalDateTime readdate;
}
