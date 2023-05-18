package org.ict.artpart.minone.model.entity;

import lombok.*;
import org.ict.artpart.minone.model.dto.MinoneDto;

import javax.persistence.*;

//Entity (테이블 정보 설정)//



@Data
@ToString                     //객체의 값 확인
@AllArgsConstructor     //생성자 자동 완성
@NoArgsConstructor     //생성자 자동 완성
@Builder                       //SQL 사용 시 파라미터에 값을 쉽게 넣어주기
@Table(name = "MINONE")
@Entity
public class MinoneEntity {
    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MIN_IDX" )
    @SequenceGenerator(name = "MIN_IDX", sequenceName = "MIN_IDX", allocationSize = 1)
    @Column(name="MIN_IDX", nullable = false)//nullable=false => null 불가 //민원번호(SEQUENCE)

    private Long minIdx;

    @Column(name="MEMBER_IDX", nullable = false)//입주민 번호
    private Long memberIdx;

    @Column(name="MIN_TITLE", nullable = false)//민원제목
    private String minTitle;

    @Column(name="MIN_TYPE", nullable = false)//민원내용
    private String minType;

    @Column(name="MIN_STATUS", nullable = false)//처리상황
    private String minStatus;

    @Column(name="MIN_RES")//관리자답변
    private String minRes;

    @Column(name="MIN_FILE")//원본파일
    private String minFile;

    @Column(name="MIN_RENAME")//변경파일
    private String minRename;

    @Column(name="MIN_CATEGORY", nullable = false)//카테고리
    private String minCategory;


    public MinoneDto toDto() {
        MinoneDto dto = new MinoneDto();
        dto.setMinIdx(this.minIdx);
        dto.setMemberIdx(this.memberIdx);
        dto.setMinTitle(this.minTitle);
        dto.setMinType(this.minType);
        dto.setMinStatus(this.minStatus);
        dto.setMinRes(this.minRes);
        dto.setMinFile(this.minFile);
        dto.setMinRename(this.minRename);
        dto.setMinCategory(this.minCategory);

        return dto;
    }
}









