package org.ict.artpart.minone.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "MINONE")
@Entity
public class MinoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "minoneSequence",
            sequenceName = "minIdx",
            allocationSize = 1)
    @Column(name="minIdx", nullable = false)//nullable=false => null 불가 //민원번호(SEQUENCE)
    private Long minIdx;

    @Column(name="memberIdx", nullable = false)//입주민 번호
    private Long memberIdx;

    @Column(name="minTitle", nullable = false)//민원제목
    private String minTitle;

    @Column(name="minType", nullable = false)//민원내용
    private String minType;

    @Column(name="minStatus", nullable = false)//처리상황
    private String minStatus;

    @Column(name="minRes")//관리자답변
    private String minRes;

    @Column(name="minFile")//원본파일
    private String minFile;

    @Column(name="minRename")//변경파일
    private String minRename;

    @Column(name="min_category", nullable = false)//카테고리
    private String minCategory;



}









