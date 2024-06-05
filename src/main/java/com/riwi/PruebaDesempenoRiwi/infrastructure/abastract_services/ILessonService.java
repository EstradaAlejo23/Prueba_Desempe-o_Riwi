package com.riwi.PruebaDesempenoRiwi.infrastructure.abastract_services;

import com.riwi.PruebaDesempenoRiwi.api.dto.request.LessonReq;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.LessonResp;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.StudentResp;

public interface ILessonService extends CrudGeneral<LessonReq, LessonResp,Long>{
    public LessonResp getById(Long id);
    public LessonResp disable(Long id);
}
