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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "minoneSequence",
            sequenceName = "minIdx",
            allocationSize = 1)
    @Column(name="MINIDX", nullable = false)//nullable=false => null 불가 //민원번호(SEQUENCE)

    private Long minIdx;

    @Column(name="MEMBERIDX", nullable = false)//입주민 번호
    private Long memberIdx;

    @Column(name="MINTITLE", nullable = false)//민원제목
    private String minTitle;

    @Column(name="MINTYPE", nullable = false)//민원내용
    private String minType;

    @Column(name="MINSTATUS", nullable = false)//처리상황
    private String minStatus;

    @Column(name="MINRES")//관리자답변
    private String minRes;

    @Column(name="MINFILE")//원본파일
    private String minFile;

    @Column(name="MINRENAME")//변경파일
    private String minRename;

    @Column(name="MINCATEGORY", nullable = false)//카테고리
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









