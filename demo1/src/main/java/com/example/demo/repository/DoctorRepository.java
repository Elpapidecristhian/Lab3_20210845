package com.example.demo.repository;

import com.example.demo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas
    List<Doctor> findAll();  // Esto obtiene todos los doctores
}