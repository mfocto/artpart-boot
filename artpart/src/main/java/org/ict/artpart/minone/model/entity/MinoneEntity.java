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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MIN_IDX")
    @SequenceGenerator(name = "MIN_IDX", sequenceName = "MIN_IDX", allocationSize = 1)
    @Column(name="MIN_IDX", nullable = false)//nullable=false => null 불가 //민원번호(SEQUENCE)
    private Long minIdx;

    @Column(name="member_idx", nullable = false)//입주민 번호
    private Long memberIdx;

    @Column(name="min_title", nullable = false)//민원제목
    private String minTitle;

    @Column(name="min_type", nullable = false)//민원내용
    private String minType;

    @Column(name="min_status", nullable = false)//처리상황
    private String minStatus;

    @Column(name="min_res")//관리자답변
    private String minRes;

    @Column(name="min_file")//원본파일
    private String minFile;

    @Column(name="min_rename")//변경파일
    private String minRename;

    @Column(name="min_category", nullable = false)//카테고리
    private String minCategory;



}









