package com.example.demo.controllers;

import com.example.demo.entity.Hospital;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Paciente;
import com.example.demo.repository.HospitalRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hospitales")
public class HospitalController {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    // Mapeo para ver la lista de hospitales


    @GetMapping
    public String viewHospitals(Model model) {
        model.addAttribute("hospitales", hospitalRepository.findAll());  // Obtener todos los hospitales
        return "hospitales/lista";  // Vista para la lista de hospitales
    }

    // Mapeo para ver doctores de un hospital específico
    @GetMapping("/{hospitalId}/doctores")
    public String viewDoctors(@PathVariable Long hospitalId, Model model) {
        model.addAttribute("doctores", doctorRepository.findByHospitalId(hospitalId));  // Obtener doctores de ese hospital
        return "hospitales/doctores";  // Vista para mostrar doctores
    }

    // Mapeo para ver pacientes de un hospital específico
    @GetMapping("/{hospitalId}/pacientes")
    public String viewPatients(@PathVariable Long hospitalId, Model model) {
        model.addAttribute("pacientes", pacienteRepository.findByHospitalId(hospitalId));  // Obtener pacientes de ese hospital
        return "hospitales/pacientes";  // Vista para mostrar pacientes
    }
}
