package com.riwi.PruebaDesempenoRiwi.infrastructure.services;

import com.riwi.PruebaDesempenoRiwi.api.dto.request.LessonReq;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.LessonResp;
import com.riwi.PruebaDesempenoRiwi.infrastructure.abastract_services.ILessonService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService{
    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public LessonResp create(LessonReq request) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public LessonResp update(Long id, LessonReq request) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Page<LessonResp> getAll(int page, int size) {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public LessonResp getById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }
}
