package com.riwi.PruebaDesempenoRiwi.api.dto.request;

import com.riwi.PruebaDesempenoRiwi.util.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentReq {
    private String name;
    private String email;
    private Status active;
    private Long clase;
}
