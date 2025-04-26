package com.example.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HospitalController {

    // Mapeo de la página de inicio
    @GetMapping("/")
    public String home() {
        return "navbar";  // Devuelve la vista de inicio
    }

    // Mapeo para ver los hospitales
    @GetMapping("/hospital")
    public String viewHospitals() {
        return "hospital";  // Devuelve la vista de hospitales
    }

    // Mapeo para ver los doctores
    @GetMapping("/doctor")
    public String viewDoctors() {
        return "doctor";  // Devuelve la vista de doctores
    }

    // Mapeo para ver los pacientes
    @GetMapping("/paciente")
    public String viewPatients() {
        return "paciente";  // Devuelve la vista de pacientes
    }
}
