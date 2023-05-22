package org.ict.artpart.minone.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.artpart.minone.model.entity.MinoneEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MinoneDto {

    private Long minIdx;                //민원번호(SEQUENCE)
    private Long memberIdx;        //입주민 번호
    private String minTitle;           //민원제목
    private String minType;          //민원내용
    private String minStatus;        //처리상황
    private String minRes;            //관리자답변
    private String minFile;           //원본파일
    private String minRename;      //변경파일
    private String minCategory;   //카테고리


}


