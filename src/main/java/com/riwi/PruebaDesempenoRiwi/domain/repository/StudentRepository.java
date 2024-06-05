package com.riwi.PruebaDesempenoRiwi.domain.repository;

import com.riwi.PruebaDesempenoRiwi.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
