package org.ict.artpart.minone.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MinoneDto {

    private Long min_idx;                //민원번호(SEQUENCE)
    private Long member_idx;        //입주민 번호
    private String min_title;           //민원제목
    private String min_type;          //민원내용
    private String min_status;        //처리상황
    private String min_res;            //관리자답변
    private String min_file;           //원본파일
    private String min_rename;      //변경파일
    private String min_category;   //카테고리



}
