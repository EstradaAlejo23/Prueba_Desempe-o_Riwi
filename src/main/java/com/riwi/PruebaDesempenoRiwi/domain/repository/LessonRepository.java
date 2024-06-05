package com.riwi.PruebaDesempenoRiwi.domain.repository;

import com.riwi.PruebaDesempenoRiwi.domain.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
