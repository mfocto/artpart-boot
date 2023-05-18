package org.ict.artpart.minone.model.entity;

import lombok.*;
import org.ict.artpart.minone.model.dto.MinoneDto;

import javax.persistence.*;

//Entity (테이블 정보 설정)//



@Data                           //getter, setter, equals, hashCode, toString 자동생성
@ToString                     //객체의 값 확인 (필요에 따라 toString() 메서드의 출력 형식을 커스터마이즈하고 싶은 경우 사용됨)
@AllArgsConstructor     //생성자 자동 완성
@NoArgsConstructor     //생성자 자동 완성
@Builder                       //SQL 사용 시 파라미터에 값을 쉽게 넣어주기
@Table(name = "MINONE")
@Entity
public class MinoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MIN_IDX")
    //@GeneratedValue 어노테이션은 PK 값을 자동으로 생성하는 방법을 설정함
    //strategy 속성은 생성 전략을 지정 (SEQUENCE 전략을 사용하도록 설정)
    //generator 속성은 사용할 식별자 생성기(generator)의 이름을 지정합니다. ("MIN_IDX"라는 이름의 식별자 생성기를 사용
    @SequenceGenerator(name = "MIN_IDX", sequenceName = "MIN_IDX", allocationSize = 1)
    //@SequenceGenerator 어노테이션은 식별자 생성기(generator)를 정의함
    //name 속성은 식별자 생성기의 이름 지정 ("MIN_IDX"라는 이름을 사용하도록 설정)
    //sequenceName => 데이터베이스에서 사용할 시퀀스(sequence)의 이름을 지정 ( "MIN_IDX"라는 이름의 시퀀스를 사용하도록 설정)
    //allocationSize => 시퀀스에서 한 번에 할당할 값의 개수를 지정합니다. (시퀀스에서 한 번에 1씩 증가하는 값을 가져오도록 설정)
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









