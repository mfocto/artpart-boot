package org.ict.artpart.minone.model.entity;

import lombok.*;

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
    @Column(name="MIN_IDX")//nullable=false => null 불가 //민원번호(SEQUENCE)
    private Long minidx;

    @Column(name="MEMBER_IDX")//입주민번호
    private Long memberidx;

    @Column(name="MIN_TITLE")//민원제목
    private String mintitle;

    @Column(name="MIN_TYPE")//민원내용
    private String mintype;

    @Column(name="MIN_STATUS")//처리상황
    private String minstatus;

    @Column(name="MIN_RES")//관리자답변
    private String minres;

    @Column(name="MIN_CATEGORY")//카테고리
    private String mincategory;


    }










