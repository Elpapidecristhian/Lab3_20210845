package com.example.demo.controllers;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Paciente;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
    @RequestMapping("/doctores")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;  // Para obtener la lista de doctores

    @Autowired
    private PacienteRepository pacienteRepository;  // Para obtener los pacientes con citas futuras


    // Mostrar la lista de doctores
    @GetMapping
    public String listarDoctores(Model model) {
        List<Doctor> doctores = doctorRepository.findAll();  // Obtener todos los doctores
        model.addAttribute("doctores", doctores);
        return "doctores/doctorList";  // Vista con la lista de doctores
    }

    // Mostrar las próximas citas de un doctor
    @GetMapping("/citas/{doctorId}")
    public String listarCitasNoAtendidas(@PathVariable Long doctorId, Model model) {
        List<Paciente> pacientes = pacienteRepository.findProximosPacientesByDoctorId(doctorId); // Obtener pacientes por doctorId
        model.addAttribute("pacientes", pacientes);
        return "doctores/citasDoctor"; // Vista con los pacientes y sus citas
    }


}
