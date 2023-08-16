package com.uce.pa2_u4_p4_al_mp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.pa2_u4_p4_al_mp.repository.modelo.Propietario;
import com.uce.pa2_u4_p4_al_mp.serviice.IPropietarioService;

@Controller
@RequestMapping("/propietarios") // el nombre siempre en plural
public class PropietarioController {

    @Autowired
    private IPropietarioService propietarioService;
    //http://
    @GetMapping("/buscar")
    public String buscarTodos(Model model){ // siempre que tebajamos con un modelo
        List<Propietario> lis = this.propietarioService.buscarTodos();
        model.addAttribute("propietarios", lis);
        return "vistaListaPropietarios";
    }
}
