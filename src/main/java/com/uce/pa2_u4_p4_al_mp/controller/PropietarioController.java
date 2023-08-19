package com.uce.pa2_u4_p4_al_mp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.pa2_u4_p4_al_mp.repository.modelo.Propietario;
import com.uce.pa2_u4_p4_al_mp.serviice.IPropietarioService;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/propietarios") // el nombre siempre en plural
public class PropietarioController {

    @Autowired
    private IPropietarioService propietarioService;
    //http://localhost:8080/concesionario/propietarios/buscar
    @GetMapping("/buscar") // algo viene y hago algo con eso :V 
    public String buscarTodos(Model model){ // siempre que tebajamos con un modelo
        List<Propietario> lis = this.propietarioService.buscarTodos();
        model.addAttribute("propietarios", lis);
        return "vistaListaPropietarios";
    }
    //http://localhost:8080/concesionario/propietarios/buscarPorId/2
    @GetMapping("/buscarPorId/{idPropietario}")
    public String buscarPorId(@PathVariable("idPropietario")Integer id,Model model){
        Propietario propietario = this.propietarioService.buscarPorId(id);
        model.addAttribute("propietario", propietario);
        return "vistaPropietario";

    }
    @PutMapping("/actualizar/{idPropietario}")
    public String actualizarPropietario(@PathVariable("idPropietario")Integer id, Propietario propietario){
        this.propietarioService.actulizar(propietario);
        return "redirect:/propietarios/buscar";
    }
}
