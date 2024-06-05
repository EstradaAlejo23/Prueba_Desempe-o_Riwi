package com.riwi.PruebaDesempenoRiwi.infrastructure.abastract_services;

import com.riwi.PruebaDesempenoRiwi.api.dto.request.ClaseReq;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.ClaseResp;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.ClaseStudentResp;

public interface IClaseService extends CrudGeneral<ClaseReq, ClaseResp,Long>{
    public ClaseStudentResp getById(Long id);
}
