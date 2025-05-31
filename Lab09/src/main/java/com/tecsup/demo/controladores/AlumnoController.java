package com.tecsup.demo.controladores;

import com.tecsup.demo.modelo.entidades.Alumno;
import com.tecsup.demo.servicios.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@SessionAttributes("alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService servicio;

    @RequestMapping(value = "/alumnos", method = RequestMethod.GET)
    public String listarAlumnos(Model model) {
        model.addAttribute("titulo", "Listado de Alumnos");
        model.addAttribute("alumnos", servicio.listar());
        return "listarAlumnoView";
    }

    @RequestMapping(value = "/alumno/form")
    public String crear(Map<String, Object> model) {
        Alumno alumno = new Alumno();
        model.put("alumno", alumno);
        model.put("titulo", "Formulario de Alumno");
        return "formAlumnoView";
    }

    @RequestMapping(value = "/alumno/form/{codigo}")
    public String editar(@PathVariable(value = "codigo") String codigo, Map<String, Object> model) {

        Alumno alumno;

        if (codigo != null && !codigo.isEmpty()) {
            alumno = servicio.buscar(codigo);
        } else {
            return "redirect:/alumnos";
        }
        model.put("alumno", alumno);
        model.put("titulo", "Editar Alumno");
        return "formAlumnoView";
    }

    @RequestMapping(value = "/alumno/form", method = RequestMethod.POST)
    public String guardar(@Validated Alumno alumno, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Alumno");
            return "formAlumnoView";
        }

        servicio.grabar(alumno);
        status.setComplete();
        return "redirect:/alumnos";
    }

    @RequestMapping(value = "/alumno/eliminar/{codigo}")
    public String eliminar(@PathVariable(value = "codigo") String codigo) {

        if (codigo != null && !codigo.isEmpty()) {
            servicio.eliminar(codigo);
        }
        return "redirect:/alumnos";
    }
}
