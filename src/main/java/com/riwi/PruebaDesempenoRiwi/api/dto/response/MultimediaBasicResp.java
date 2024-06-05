package com.riwi.PruebaDesempenoRiwi.api.dto.response;

import com.riwi.PruebaDesempenoRiwi.util.enums.Status;
import com.riwi.PruebaDesempenoRiwi.util.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaBasicResp{
    private Long id;
    private String url;
    private Type type;
    private LocalDateTime createdAt;
    private Status active;
}
