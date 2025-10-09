package com.app_parents_backend.backend.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.app_parents_backend.backend.model.prueba; // poo 
import com.app_parents_backend.backend.repository.pruebaRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class WebController {
    @Autowired
    private pruebaRepository pruebaRepository;

    @GetMapping("/index")
    public String showHomePage() {
        // Return the name of the HTML file (index.html)
        return "index"; // Renderiza index.html
    }

    /*
     * Dentro de aca escuchamos el formulario
     * 
     * obtenemos el input - "mensaje"
     * 
     */
    @PostMapping("/mensaje")
    public String guardarMensaje(@RequestParam("contenido") String contenido, Model model) {
        prueba nuevo = new prueba(contenido);
        pruebaRepository.save(nuevo);

        model.addAttribute("mensajeExito", "✅ Mensaje guardado correctamente");
        return "index"; // Vuelve a mostrar el formulario con el mensaje de éxito
    }
}