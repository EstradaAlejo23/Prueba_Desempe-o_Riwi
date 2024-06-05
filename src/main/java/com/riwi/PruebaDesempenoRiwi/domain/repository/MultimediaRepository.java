package com.riwi.PruebaDesempenoRiwi.domain.repository;

import com.riwi.PruebaDesempenoRiwi.domain.entities.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultimediaRepository extends JpaRepository<Multimedia, Long> {
}
