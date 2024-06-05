package com.riwi.PruebaDesempenoRiwi.infrastructure.services;

import com.riwi.PruebaDesempenoRiwi.api.dto.request.MultimediaReq;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.MultimediaResp;
import com.riwi.PruebaDesempenoRiwi.infrastructure.abastract_services.IMultimediaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MultimediaService implements IMultimediaService {
    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public MultimediaResp create(MultimediaReq request) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public MultimediaResp update(Long aLong, MultimediaReq request) {
        return null;
    }


    @Override
    public Page<MultimediaResp> getAll(int page, int size) {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public MultimediaResp getById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }
}
