package com.riwi.PruebaDesempenoRiwi.api.controllers;

import java.util.HashMap;
import java.util.Map;

import com.riwi.PruebaDesempenoRiwi.api.dto.request.StudentReq;
import com.riwi.PruebaDesempenoRiwi.api.dto.response.StudentResp;
import com.riwi.PruebaDesempenoRiwi.infrastructure.abastract_services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    @Autowired
    private final IStudentService objStudentService;

    @GetMapping
    public ResponseEntity<Page<StudentResp>> getAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "1") int size){
        return  ResponseEntity.ok(this.objStudentService.getAll(page -1, size));
    }

    @PostMapping
    public ResponseEntity<StudentResp> insert (@RequestBody StudentReq request){
        return  ResponseEntity.ok(this.objStudentService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResp> update(@Validated @RequestBody StudentReq request,
                                                  @PathVariable Long id){
        return ResponseEntity.ok(this.objStudentService.update(id, request));
    }

    @PatchMapping("/{id}/disable")
    public ResponseEntity<StudentResp> delete(@PathVariable Long id){
        return ResponseEntity.ok(this.objStudentService.disable(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResp> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.objStudentService.getById(id));
    }
}
