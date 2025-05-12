package com.example.demo.repository;

import com.example.demo.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    // Obtiene todos los hospitales
    List<Hospital> findAll();
}
