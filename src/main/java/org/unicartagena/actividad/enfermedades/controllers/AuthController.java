package org.unicartagena.actividad.enfermedades.controllers;

import org.unicartagena.actividad.enfermedades.models.Users;
import org.unicartagena.actividad.enfermedades.enums.UsuarioEnum;
import org.unicartagena.actividad.enfermedades.services.MailService;
import org.unicartagena.actividad.enfermedades.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    @Autowired private UserService usuarioService;
    @Autowired private MailService mailService;

    @GetMapping("/login")
    public String login() { return "login"; }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        Users u = usuarioService.autenticate(email, password);
        if (u != null) {
            session.setAttribute("usuarioLogueado", u);
            return "redirect:/enfermedades";
        }
        model.addAttribute("error", "Credenciales inválidas");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @PostMapping("/recuperar")
    public String recuperar(@RequestParam String email, Model model) {
        Users u = usuarioService.searchByEmail(email);
        if (u != null) {
            model.addAttribute("mensaje", "Correo enviado");
        } else {
            model.addAttribute("error", "Correo no existe");
        }
        return "login";
    }
}