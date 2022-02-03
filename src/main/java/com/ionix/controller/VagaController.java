package com.ionix.controller;

import com.ionix.model.Vaga;
import com.ionix.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VagaController {

    @Autowired
    private VagaRepository vagaRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/vagas")
    public ModelAndView vagas(){
        ModelAndView modelAndView = new ModelAndView("pages/vagas");
        Iterable<Vaga> vagas = vagaRepository.findAll();
        modelAndView.addObject("vagas", vagas);
        return modelAndView;
    }


    @GetMapping("/recrutador")
    public String recrutador(){
        return "pages/recrutador";
    }

    @PostMapping("/recrutador")
    public String cadastroRecrutador( Vaga vaga) {
        vagaRepository.save(vaga);
        return "pages/recrutador";
    }

    @GetMapping("/vaga-detalhe/{id}")
    public ModelAndView detalheVaga(@PathVariable(name="id") Long id) {
        Vaga vagas = vagaRepository.getById(id);
        ModelAndView model = new ModelAndView("pages/candidato");
        model.addObject("vagas", vagas);
        return model;
    }
}
