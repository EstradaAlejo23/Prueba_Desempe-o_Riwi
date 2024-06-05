package com.riwi.PruebaDesempenoRiwi.api.dto.response;

import com.riwi.PruebaDesempenoRiwi.domain.entities.Clase;
import com.riwi.PruebaDesempenoRiwi.util.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResp {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private Status active;
    private ClaseResp clase;
}
