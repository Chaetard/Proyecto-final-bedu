package com.example.demo.controller;

import com.example.demo.entity.Tarea;
import com.example.demo.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping("/tareas")
    public String index(Model model) {
            model.addAttribute("tareas", tareaRepository.findAll());
            model.addAttribute("tarea", new Tarea());
            return "index";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Tarea> tareaOptional = tareaRepository.findById(id);
        if (tareaOptional.isPresent()) {
            model.addAttribute("tarea", tareaOptional.get());
            return "editar"; 
        } else {
            return "error"; 
        }
    }

    @PostMapping("/guardar")
    public String guardarTarea(@ModelAttribute Tarea tarea) {
        tarea.setEstado("pendiente");
        tareaRepository.save(tarea);
        return "redirect:/tareas";
    }

    @PostMapping("/eliminar")
    public String eliminarTarea(@RequestParam("id") Long id) {
       
        tareaRepository.deleteById(id);
        return "redirect:/tareas";
    }

    @PostMapping("/moverProceso")
    public String moverProceso(@RequestParam("id") Long id) {
        Optional<Tarea> tareaOptional = tareaRepository.findById(id);
        if (tareaOptional.isPresent()) {
            Tarea tarea = tareaOptional.get();
            tarea.setEstado("proceso");
            tareaRepository.save(tarea); 
        } else {
           
            return "error"; 
        }
        return "redirect:/tareas";
    }

    @PostMapping("/moverTerminada")
    public String moverTerminada(@RequestParam("id") Long id) {
        Optional<Tarea> tareaOptional = tareaRepository.findById(id);
        if (tareaOptional.isPresent()) {
            Tarea tarea = tareaOptional.get();
            tarea.setEstado("terminada");
            tareaRepository.save(tarea); 
        } else {
            
            return "error";
        }
        return "redirect:/tareas";
    }

}