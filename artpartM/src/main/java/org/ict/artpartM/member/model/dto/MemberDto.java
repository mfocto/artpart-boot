package org.ict.artpartM.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.artpartM.apt.entity.AptEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
    private long memberidx;
    private AptEntity aptidx;
    private String memberdong;
    private String memberho;
    private String membername;
    private String memberid;
    private String memberpassword;
    private String memberphone;
    private String memberloginok;
    private String membermycar1;
    private String membermycar2;
}
