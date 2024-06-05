package com.riwi.PruebaDesempenoRiwi.api.dto.response;

import com.riwi.PruebaDesempenoRiwi.domain.entities.Lesson;
import com.riwi.PruebaDesempenoRiwi.domain.entities.Student;
import com.riwi.PruebaDesempenoRiwi.util.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClaseResp {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createAt;
    private Status active;
}
