package com.riwi.PruebaDesempenoRiwi.infrastructure.services;

import com.riwi.PruebaDesempenoRiwi.api.dto.request.LessonReq;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.*;
import com.riwi.PruebaDesempenoRiwi.domain.entities.Clase;
import com.riwi.PruebaDesempenoRiwi.domain.entities.Lesson;
import com.riwi.PruebaDesempenoRiwi.domain.entities.Multimedia;
import com.riwi.PruebaDesempenoRiwi.domain.repository.ClaseRepository;
import com.riwi.PruebaDesempenoRiwi.domain.repository.LessonRepository;
import com.riwi.PruebaDesempenoRiwi.infrastructure.abastract_services.ILessonService;
import com.riwi.PruebaDesempenoRiwi.util.enums.Status;
import com.riwi.PruebaDesempenoRiwi.util.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService{

    @Autowired
    private final  LessonRepository objLessonRepository;

    @Autowired
    private final ClaseRepository objClaseRepository;


    @Override
    public LessonResp disable(Long id) {
        Lesson objLesson = this.find(id);
        objLesson.setActive(Status.INACTIVE);
        return this.entityToResponse(this.objLessonRepository.save(objLesson));
    }

    @Override
    public void delete(Long aLong) {
    }

    @Override
    public LessonResp create(LessonReq request) {
        Lesson lesson = this.entityToRequest(request);

        return this.entityToResponse(this.objLessonRepository.save(lesson));
    }

    @Override
    public LessonResp update(Long id, LessonReq request) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Page<LessonResp> getAll(int page, int size) {
        if(page < 0) page = 0;

        PageRequest paginable = PageRequest.of(page, size);

        return this.objLessonRepository.findAll(paginable).map(this::entityToResponse);
    }

    @Override
    public LessonResp getById(Long id) {
        return  this.entityToResponse(find(id));
    }

    private Lesson find(Long id){
        return this.objLessonRepository.findById(id).orElseThrow(()-> new BadRequestException("No hay Lecciones con el id suministrado"));
    }

    private Lesson entityToRequest(LessonReq request){
        Clase clase = this.objClaseRepository.findById(request.getClassId()).orElseThrow();
        return Lesson.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .createAt(LocalDateTime.now())
                .active(request.getActive())
                .clase(clase)
                .build();
    }

    private LessonResp entityToResponse(Lesson entity){
        ClaseResp classResponse = ClaseResp.builder()
                .id(entity.getClase().getId())
                .name(entity.getClase().getName())
                .description(entity.getClase().getDescription())
                .createAt(entity.getClase().getCreateAt())
                .active(entity.getClase().getActive())
                .build();

        List<MultimediaBasicResp> multimedia = entity.getMultimedia()
                .stream()
                .map(this::entityToResponseMultimedia)
                .collect(Collectors.toList());

        return LessonResp.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .createAt(entity.getCreateAt())
                .active(entity.getActive())
                .clase(classResponse)
                .multimedia(multimedia)
                .build();

    }

    private MultimediaBasicResp entityToResponseMultimedia(Multimedia entity){

        return MultimediaBasicResp.builder()
                .url(entity.getUrl())
                .type(entity.getType())
                .createdAt(entity.getCreatedAt())
                .active(entity.getActive())
                .build();
    }
}
