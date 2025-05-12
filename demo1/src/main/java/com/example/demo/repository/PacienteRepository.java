package com.example.demo.repository;

import com.example.demo.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    // Consulta personalizada para obtener todos los pacientes de un doctor
    @Query("SELECT p FROM Paciente p WHERE p.doctor.id = :doctorId")
    List<Paciente> findProximosPacientesByDoctorId(@Param("doctorId") Long doctorId);
}
