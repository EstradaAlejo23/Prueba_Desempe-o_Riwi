package com.riwi.PruebaDesempenoRiwi.api.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonReq {
    @NotBlank(message = "El titulo es requerido")
    @Size(
            min = 1,
            max = 255,
            message = "El titulo debe tener entre 1 y 255 caracteres"
    )
    private String title;
    private String content;
    @FutureOrPresent(message = "La fecha y hora debe ser futura")
    @NotNull(message = "La fecha y hora de la cita es requeridas")
    private LocalDateTime createAt;
    @NotNull( message = "El estado es requerido")
    private Boolean active;
}
