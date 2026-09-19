package org.unicartagena.actividad.enfermedades.controllers;

import org.unicartagena.actividad.enfermedades.models.Enfermedades;
import org.unicartagena.actividad.enfermedades.enums.NivelGravedadEnum;
import org.unicartagena.actividad.enfermedades.services.EnfermedadesServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/enfermedades")
public class EnfermedadController {
    @Autowired private EnfermedadesServices service;

    private boolean auth(HttpSession session) { return session.getAttribute("usuarioLogueado") != null; }

    @GetMapping
    public String listar(Model model, HttpSession session) {
        if(!auth(session)) return "redirect:/login";
        model.addAttribute("enfermedades", service.listEnfermedades());
        return "enfermedades/lista";
    }

    @GetMapping("/nuevaEnfermedad")
    public String nuevo(Model model, HttpSession session) {
        if(!auth(session)) return "redirect:/login";
        model.addAttribute("enfermedad", new Enfermedades());
        return "enfermedades/formulario";
    }

    @PostMapping("/guardarEnfermedad")
    public String guardar(@ModelAttribute Enfermedades e) {
        service.saveEnfermedades(e);
        return "redirect:/enfermedades";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, HttpSession session) {
        if(!auth(session)) return "redirect:/login";
        service.deleteEnfermedades(id);
        return "redirect:/enfermedades";
    }

    @GetMapping("/reporte/gravedad")
    public String reporteGravedad(@RequestParam NivelGravedadEnum nivel, Model model, HttpSession session) {
        if(!auth(session)) return "redirect:/login";
        model.addAttribute("enfermedades", service.reporteGravedad(nivel));
        return "enfermedades/lista";
    }
}
