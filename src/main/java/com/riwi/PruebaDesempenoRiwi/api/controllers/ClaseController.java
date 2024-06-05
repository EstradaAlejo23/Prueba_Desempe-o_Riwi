package com.riwi.PruebaDesempenoRiwi.api.controllers;

import com.riwi.PruebaDesempenoRiwi.api.dto.request.ClaseReq;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.ClaseResp;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.ClaseStudentResp;
import com.riwi.PruebaDesempenoRiwi.infrastructure.abastract_services.IClaseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clase")
@AllArgsConstructor
public class ClaseController {

    @Autowired
    private final IClaseService objClaseService;

    @GetMapping
    public ResponseEntity<Page<ClaseResp>> getAll(@RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "1")int size){
        return ResponseEntity.ok(this.objClaseService.getAll(page-1,size));
    }

    @PostMapping
    public ResponseEntity<ClaseResp> insert(@Validated @RequestBody ClaseReq req){
        return ResponseEntity.ok(this.objClaseService.create(req));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClaseStudentResp> getById(
            @PathVariable Long id){
        return ResponseEntity.ok(this.objClaseService.getById(id));
    }


}
