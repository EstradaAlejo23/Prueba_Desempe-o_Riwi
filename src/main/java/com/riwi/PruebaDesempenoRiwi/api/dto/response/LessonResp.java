package com.riwi.PruebaDesempenoRiwi.api.dto.response;

import com.riwi.PruebaDesempenoRiwi.domain.entities.Clase;
import com.riwi.PruebaDesempenoRiwi.domain.entities.Multimedia;
import com.riwi.PruebaDesempenoRiwi.util.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonResp {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private Status active;
    List<MultimediaBasicResp> multimedia;
    private ClaseResp clase;
}
