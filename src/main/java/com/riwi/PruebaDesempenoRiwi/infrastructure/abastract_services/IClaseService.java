package com.riwi.PruebaDesempenoRiwi.infrastructure.abastract_services;

import com.riwi.PruebaDesempenoRiwi.api.dto.request.ClaseReq;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.ClaseResp;

public interface IClaseService extends CrudGeneral<ClaseReq, ClaseResp,Long>{
    public ClaseResp getById(Long id);
}
