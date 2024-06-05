package com.riwi.PruebaDesempenoRiwi.infrastructure.services;

import com.riwi.PruebaDesempenoRiwi.api.dto.request.ClaseReq;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.ClaseResp;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.ClaseStudentResp;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.LessonResp;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.StudentResp;
import com.riwi.PruebaDesempenoRiwi.domain.entities.Clase;
import com.riwi.PruebaDesempenoRiwi.domain.entities.Student;
import com.riwi.PruebaDesempenoRiwi.domain.repository.ClaseRepository;
import com.riwi.PruebaDesempenoRiwi.infrastructure.abastract_services.IClaseService;
import com.riwi.PruebaDesempenoRiwi.util.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ClaseService implements IClaseService {
    @Autowired
    private final ClaseRepository objClassRepository;

    @Override
    public void delete(Long id) {
    }

    @Override
    public ClaseResp create(ClaseReq request) {
        Clase clase =  this.EntityToRequest(request);
        return  this.entityToResponse(this.objClassRepository.save(clase));
    }

    @Override
    public ClaseResp update(Long aLong, ClaseReq request) {
        return null;
    }


    @Override
    public Page<ClaseResp> getAll(int page, int size) {
        if (page <0) page = 0;

        PageRequest paginable = PageRequest.of(page, size);

        return this.objClassRepository.findAll(paginable).map(this::entityToResponse);
    }

    @Override
    public ClaseStudentResp getById(Long id) {
        return  this.entityToResponseStudent(find(id));
    }

    private Clase find(Long id){
        return this.objClassRepository.findById(id).orElseThrow(()-> new BadRequestException("No hay Clases con el id suministrado"));
    }

    private Clase EntityToRequest(ClaseReq request){
        return Clase.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .createAt(LocalDateTime.now())
                .active(request.getActive())
                .build();
    }

    private ClaseResp entityToResponse (Clase entity){
        return ClaseResp.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .createAt(entity.getCreateAt())
                .active(entity.getActive())
                .build();
    }

    private ClaseStudentResp entityToResponseStudent (Clase entity){

        StudentResp student = new StudentResp();
        BeanUtils.copyProperties(entity, student);

        return ClaseStudentResp.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .createAt(entity.getCreateAt())
                .active(entity.getActive())
                .students(student)
                .build();
    }



    public ClaseResp getByName(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }


    public ClaseResp getByDescription(String description) {
        throw new UnsupportedOperationException("Unimplemented method 'getByDescription'");
    }
}
