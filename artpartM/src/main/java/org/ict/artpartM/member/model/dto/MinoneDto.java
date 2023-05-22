package org.ict.artpartM.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.artpartM.member.entity.MemberEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MinoneDto {
    private long minidx;
    private MemberEntity memberidx;
    private String mintitle;
    private String mintype;
    private String minstatus;
    private String minres;
    private String minfile;
    private String minrename;
    private String mincategory;
}
