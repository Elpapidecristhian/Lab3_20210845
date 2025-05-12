package com.example.demo.repository;

import com.example.demo.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    // Actualiza el doctor de un paciente específico
    @Modifying
    @Transactional
    @Query("UPDATE Paciente p SET p.doctor.id = :doctorId WHERE p.id = :pacienteId")
    void updateDoctorForPaciente(Long pacienteId, Long doctorId);
}
