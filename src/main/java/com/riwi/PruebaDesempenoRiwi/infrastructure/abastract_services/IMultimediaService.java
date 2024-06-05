package com.riwi.PruebaDesempenoRiwi.infrastructure.abastract_services;

import com.riwi.PruebaDesempenoRiwi.api.dto.request.MultimediaReq;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.MultimediaResp;

public interface IMultimediaService extends CrudGeneral<MultimediaReq, MultimediaResp,Long>{
    public MultimediaResp getById(Long id);
}
