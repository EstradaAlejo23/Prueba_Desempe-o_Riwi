package com.riwi.PruebaDesempenoRiwi.api.controllers;

import com.riwi.PruebaDesempenoRiwi.api.dto.request.ClaseReq;
import com.riwi.PruebaDesempenoRiwi.api.dto.request.LessonReq;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.ClaseResp;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.ClaseStudentResp;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.LessonResp;
import com.riwi.PruebaDesempenoRiwi.infrastructure.abastract_services.ILessonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lesson")
@AllArgsConstructor
public class LessonController {
    @Autowired
    private final ILessonService objLessonService;


    @GetMapping
    public ResponseEntity<Page<LessonResp>> getAll(@RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "1")int size){
        return ResponseEntity.ok(this.objLessonService.getAll(page-1,size));
    }

    @PostMapping
    public ResponseEntity<LessonResp> insert(@Validated @RequestBody LessonReq req){
        return ResponseEntity.ok(this.objLessonService.create(req));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<LessonResp> getById(
            @PathVariable Long id){
        return ResponseEntity.ok(this.objLessonService.getById(id));
    }

}
