package org.ict.artpartM.sendSms.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class MessageDTO {
    String to;
    String content;
}
