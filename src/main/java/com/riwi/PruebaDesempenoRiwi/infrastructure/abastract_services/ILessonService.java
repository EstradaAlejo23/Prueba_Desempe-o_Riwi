package com.riwi.PruebaDesempenoRiwi.infrastructure.abastract_services;

import com.riwi.PruebaDesempenoRiwi.api.dto.request.LessonReq;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.LessonResp;

public interface ILessonService extends CrudGeneral<LessonReq, LessonResp,Long>{
    public LessonResp getById(Long id);
}
