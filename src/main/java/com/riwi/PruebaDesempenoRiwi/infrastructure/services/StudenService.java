package com.riwi.PruebaDesempenoRiwi.infrastructure.services;

import com.riwi.PruebaDesempenoRiwi.api.dto.request.StudentReq;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.StudentResp;
import com.riwi.PruebaDesempenoRiwi.infrastructure.abastract_services.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudenService implements IStudentService {
    @Override
    public StudentResp getById(Long id) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public StudentResp create(StudentReq request) {
        return null;
    }

    @Override
    public StudentResp update(Long aLong, StudentReq request) {
        return null;
    }

    @Override
    public Page<StudentResp> getAll(int page, int size) {
        return null;
    }
}
