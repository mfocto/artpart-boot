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

    private Long minidx;                //민원번호(SEQUENCE)
    private Long memberidx;        //입주민 번호
    private String mintitle;           //민원제목
    private String mintype;          //민원내용
    private String minstatus;        //처리상황
    private String minres;            //관리자답변
    private String mincategory;   //카테고리


}


