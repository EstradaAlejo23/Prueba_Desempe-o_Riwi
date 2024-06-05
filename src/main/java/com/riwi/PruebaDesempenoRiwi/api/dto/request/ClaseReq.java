package com.riwi.PruebaDesempenoRiwi.api.dto.request;

import com.riwi.PruebaDesempenoRiwi.api.dto.response.LessonResp;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.StudentResp;
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
public class ClaseReq {
    @NotBlank(message = "El nombre es requerido")
    @Size(
            min = 1,
            max = 100,
            message = "El nombre debe tener entre 1 y 100 caracteres"
    )
    private String name;
    private String description;
    @FutureOrPresent(message = "La fecha y hora debe ser futura")
    @NotNull(message = "La fecha y hora de la cita es requeridas")
    private LocalDateTime createAt;
    @NotNull(message = "El estado es requerido")
    private Boolean active;

}
