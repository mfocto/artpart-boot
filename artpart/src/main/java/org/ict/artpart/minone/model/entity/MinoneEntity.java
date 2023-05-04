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
            sequenceName = "min_idx",
            allocationSize = 1)
    @Column(name="min_idx", nullable = false)//nullable=false => null 불가 //민원번호(SEQUENCE)
    private Long min_idx;

    @Column(name="member_idx", nullable = false)//입주민 번호
    private Long member_idx;

    @Column(name="min_title", nullable = false)//민원제목
    private String min_title;

    @Column(name="min_type", nullable = false)//민원내용
    private String min_type;

    @Column(name="min_status", nullable = false)//처리상황
    private String min_status;

    @Column(name="min_res")//관리자답변
    private String min_res;

    @Column(name="min_file")//원본파일
    private String min_file;

    @Column(name="min_rename")//변경파일
    private String min_rename;

    @Column(name="min_category", nullable = false)//카테고리
    private String min_category;



}









