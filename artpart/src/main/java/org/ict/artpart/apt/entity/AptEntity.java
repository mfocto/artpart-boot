package org.ict.artpart.apt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "APT")
@Builder

public class AptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APT_IDX")
    @SequenceGenerator(name = "APT_IDX", sequenceName = "APT_IDX", allocationSize = 1)
    @Column(name = "APT_IDX")
    private long aptIdx;            //아파트 번호

    @Column(name = "APT_ROAD")
    private String aptRoad;         //도로명 주소

    @Column(name = "APT_ADD")
    private String aptAdd;          //지번 주소

    @Column(name = "APT_COUNT")
    private int aptCount;           //총 세대수

    @Column(name = "APT_RCOUNT")
    private int aptRCount;          //거저중인 세대수

    @Column(name = "APT_PHONE")
    private String aptPhone;        //관리소 연락처
}
