package com.ionix.controller;

import com.ionix.model.Candidato;
import com.ionix.model.Vaga;
import com.ionix.repository.CandidatoRepository;
import com.ionix.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CandidatoController {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private VagaRepository vagaRepository;

    @GetMapping("/candidato")
    public String candidato(){
        return "pages/candidato";
    }


    @PostMapping("/vaga-detalhe/{id}")
    public String detalheVaga(@PathVariable(name="id") Long id, Candidato candidato) {
        Vaga vaga = vagaRepository.getById(id);
        candidato.setVaga(vaga);
        candidatoRepository.save(candidato);
        return "redirect:/vaga-detalhe/{id}";
    }

}
