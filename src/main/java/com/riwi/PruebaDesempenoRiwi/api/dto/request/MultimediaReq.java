package com.riwi.PruebaDesempenoRiwi.api.dto.request;

import com.riwi.PruebaDesempenoRiwi.util.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MultimediaReq {
    private String url;
    private Type type;
    private LocalDateTime createdAt;
    private Boolean active;
}
