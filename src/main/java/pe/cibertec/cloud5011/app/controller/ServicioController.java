package pe.cibertec.cloud5011.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.cloud5011.app.model.Servicio;
import pe.cibertec.cloud5011.app.repository.ServicioRepository;

import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
public class ServicioController {

    private final ServicioRepository servicioRepository;

    @GetMapping({"/", "/servicios"})
    public String listarServicios(Model model) {
        model.addAttribute("servicios", servicioRepository.findAll());
        model.addAttribute("nuevoServicio", new Servicio());
        return "servicios";
    }

    @PostMapping("/servicios")
    public String guardarServicio(@RequestParam String nombre,
                                  @RequestParam BigDecimal precio) {
        Servicio s = new Servicio();
        s.setNombre(nombre);
        s.setPrecio(precio);
        servicioRepository.save(s);
        return "redirect:/servicios";
    }
}