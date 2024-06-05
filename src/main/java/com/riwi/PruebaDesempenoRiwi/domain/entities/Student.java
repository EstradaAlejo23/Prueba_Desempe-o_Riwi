package com.riwi.PruebaDesempenoRiwi.domain.entities;

import com.riwi.PruebaDesempenoRiwi.util.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "student")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255, nullable = false)
    private String name;
    @Column(length = 255, nullable = false)
    private String email;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private Status active;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clase_id",referencedColumnName = "id",nullable = false)
    private Clase clase;
}
