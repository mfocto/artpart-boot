package org.ict.artpart.apt.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AptDto {
    private long aptIdx;            //아파트 번호
    private String aptRoad;         //도로명 주소
    private String aptAdd;          //지번 주소
    private int aptCount;           //총 세대수
    private int aptRCount;          //거저중인 세대수
    private String aptPhone;        //관리소 연락처
}
