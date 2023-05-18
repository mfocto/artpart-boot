package org.ict.artpart.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    private long memberIdx;
    private String memberAdd;
    private String memberDong;
    private String memberHo;
    private String memberName;
    private String memberId;
    private String memberPw;
    private String memberPhone;
    private String memberLoginOK;
    private String memberMycar1;
    private String memberMycar2;
}
