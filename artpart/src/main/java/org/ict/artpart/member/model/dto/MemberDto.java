package org.ict.artpart.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
    private long memberIdx;             //입주민 번호
    private long aptIdx;                //아파트 번호
    private String memberDong;          //동
    private String memberHo;            //호수
    private String memberName;          //이름
    private String memberId;            //아이디
    private String memberPassword;      //비밀번호
    private String memberPhone;         //전화번호
    private String memberLoginOK;       //입주완료 여부
    private String memberMyCar1;        //등록차번호 1
    private String memberMyCar2;        //등록차번호 2
}
