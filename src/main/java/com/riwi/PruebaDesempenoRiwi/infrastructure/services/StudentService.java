package com.riwi.PruebaDesempenoRiwi.infrastructure.services;

import com.riwi.PruebaDesempenoRiwi.api.dto.request.StudentReq;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.ClaseResp;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.StudentResp;
import com.riwi.PruebaDesempenoRiwi.domain.entities.Clase;
import com.riwi.PruebaDesempenoRiwi.domain.entities.Student;
import com.riwi.PruebaDesempenoRiwi.domain.repository.ClaseRepository;
import com.riwi.PruebaDesempenoRiwi.domain.repository.StudentRepository;
import com.riwi.PruebaDesempenoRiwi.infrastructure.abastract_services.IStudentService;
import com.riwi.PruebaDesempenoRiwi.util.enums.Status;
import com.riwi.PruebaDesempenoRiwi.util.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService {
    @Autowired
    private final StudentRepository objStudentRepository;

    @Autowired
    private final ClaseRepository objClassRepository;

    @Override
    public void delete(Long id) {
        this.objStudentRepository.delete(this.find(id));
    }

    @Override
    public StudentResp create(StudentReq request) {
        Student student = this.EntityToRequest(request);

        return  this.entityToResponse(this.objStudentRepository.save(student));
    }

    @Override
    public StudentResp update(Long id, StudentReq request) {
        Student objStudent = this.find(id);
        Student objStundetUpdate = this.EntityToRequest(request);
        objStundetUpdate.setId(objStudent.getId());
        return this.entityToResponse(this.objStudentRepository.save(objStundetUpdate));
    }

    @Override
    public StudentResp disable(Long id) {
        Student objStudent = this.find(id);
       objStudent.setActive(Status.INACTIVE);
        return this.entityToResponse(this.objStudentRepository.save(objStudent));
    }

    @Override
    public Page<StudentResp> getAll(int page, int size) {
        if(page <0) page = 0;

        PageRequest paginable = PageRequest.of(page,size);

        return  this.objStudentRepository.findAll(paginable).map(this::entityToResponse);
    }

    @Override
    public StudentResp getById(Long id) {
        return  this.entityToResponse(this.find(id));
    }

    private Student find(Long id){
        return  this.objStudentRepository.findById(id).orElseThrow(()-> new BadRequestException("No hay Estudiantes con el id suministrado"));
    }

    private Student EntityToRequest  (StudentReq request){
        Clase clase = this.objClassRepository.findById(request.getClase()).orElseThrow();
        if (clase.getId() == null) {
            throw new BadRequestException("El id ingresado es invalido no existe");
        }

        return Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .active(request.getActive())
                .createdAt(LocalDateTime.now())
                .clase(clase)
                .build();
    }

    private StudentResp entityToResponse (Student entity){
        ClaseResp classResp = ClaseResp.builder()
                .id(entity.getClase().getId())
                .name(entity.getClase().getName())
                .description(entity.getClase().getDescription())
                .createAt(entity.getClase().getCreateAt())
                .active(entity.getClase().getActive())
                .build();

        return StudentResp.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .createdAt(LocalDateTime.now())
                .active(entity.getActive())
                .clase(classResp)
                .build();
    }
}
