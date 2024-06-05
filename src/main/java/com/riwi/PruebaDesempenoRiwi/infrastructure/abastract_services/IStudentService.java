package com.riwi.PruebaDesempenoRiwi.infrastructure.abastract_services;

import com.riwi.PruebaDesempenoRiwi.api.dto.request.StudentReq;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.StudentResp;

public interface IStudentService extends CrudGeneral<StudentReq,StudentResp,Long>{
    public StudentResp getById(Long id);
}
