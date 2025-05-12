package com.example.demo.controllers;

import com.example.demo.repository.PacienteRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.HospitalRepository;
import com.example.demo.entity.Paciente;
import com.example.demo.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    // Muestra la lista de pacientes
    @GetMapping
    public String listarPacientes(Model model) {
        List<Paciente> pacientes = pacienteRepository.findAll();
        model.addAttribute("pacientes", pacientes);
        return "pacientes/lista"; // Vista con la lista de pacientes
    }

    // Muestra el formulario para derivar pacientes
    @GetMapping("/derivar/{pacienteId}")
    public String mostrarFormularioDerivacion(@PathVariable Long pacienteId, Model model) {
        Paciente paciente = pacienteRepository.findById(pacienteId).orElse(null);
        if (paciente != null) {
            model.addAttribute("paciente", paciente);
            List<Doctor> doctores = doctorRepository.findAll(); // Obtener la lista de doctores
            model.addAttribute("doctores", doctores);
        }
        return "pacientes/derivar"; // Vista para el formulario de derivación
    }

    // Maneja la derivación de un paciente
    @PostMapping("/derivar/{pacienteId}")
    public String derivarPaciente(@PathVariable Long pacienteId, @RequestParam Long doctorId, Model model) {
        // Llamamos al método que actualiza el doctor del paciente
        pacienteRepository.updateDoctorForPaciente(pacienteId, doctorId);
        return "redirect:/pacientes"; // Redirige de vuelta a la lista de pacientes
    }

}




