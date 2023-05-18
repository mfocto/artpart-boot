package org.ict.artpartM.read.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.artpartM.member.entity.MemberEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReadDto {
    private long readidx;
    private MemberEntity memberidx;
    private long lastelectric;
    private long electric;
    private long lasthotwater;
    private long hotwater;
    private long lastwater;
    private long water;
    private long lastheat;
    private long heat;
    private String readdate;

}
