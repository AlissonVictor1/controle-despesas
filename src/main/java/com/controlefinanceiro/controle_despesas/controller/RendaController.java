package com.controlefinanceiro.controle_despesas.controller;

import com.controlefinanceiro.controle_despesas.model.Renda;
import com.controlefinanceiro.controle_despesas.repository.RendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rendas")
public class RendaController {

    @Autowired
    private RendaRepository rendaRepository;

    @GetMapping
    public List<Renda> listarRendas() {
        return rendaRepository.findAll();
    }

    @PostMapping
    public Renda criarRenda(@RequestBody Renda renda) {
        return rendaRepository.save(renda);
    }
}
