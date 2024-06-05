package com.riwi.PruebaDesempenoRiwi.domain.repository;


import com.riwi.PruebaDesempenoRiwi.api.dto.request.StudentReq;
import com.riwi.PruebaDesempenoRiwi.domain.entities.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepository extends JpaRepository<Clase,Long>{
}
