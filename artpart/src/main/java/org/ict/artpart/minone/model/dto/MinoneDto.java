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




    //Dto 객체를 Entity 객체로 변환
    public MinoneEntity toEntity() {
        MinoneEntity entity = new MinoneEntity();
        entity.setMinIdx(this.minIdx);
        entity.setMemberIdx(this.memberIdx);
        entity.setMinTitle(this.minTitle);
        entity.setMinType(this.minType);
        entity.setMinStatus(this.minStatus);
        entity.setMinRes(this.minRes);
        entity.setMinFile(this.minFile);
        entity.setMinRename(this.minRename);
        entity.setMinCategory(this.minCategory);
        return entity;
    }

    //minoneEntity 개체에서 관련 속성을 추출하고 이를 MinoneDto 개체의 해당 속성에 할당
    public MinoneDto(MinoneEntity minoneEntity) {
        this.minIdx = minoneEntity.getMinIdx();
        this.memberIdx = minoneEntity.getMemberIdx();
        this.minTitle = minoneEntity.getMinTitle();
        this.minType = minoneEntity.getMinType();
        this.minStatus = minoneEntity.getMinStatus();
        this.minRes = minoneEntity.getMinRes();
        this.minFile = minoneEntity.getMinFile();
        this.minRename = minoneEntity.getMinRename();
        this.minCategory = minoneEntity.getMinCategory();
    }


}
