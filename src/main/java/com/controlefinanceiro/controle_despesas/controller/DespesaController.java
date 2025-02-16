package com.controlefinanceiro.controle_despesas.controller;


import com.controlefinanceiro.controle_despesas.model.Despesa;
import com.controlefinanceiro.controle_despesas.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despesas")
public class DespesaController {
    @Autowired
    //é usada para injetar automaticamente a dependência do DespesaRepository no serviço.
    private DespesaRepository despesaRepository;

    @GetMapping
    public List<Despesa> listarDespesas(){
        return despesaRepository.findAll();
    }
    @PostMapping
    public Despesa criarDespesa(@RequestBody Despesa despesa) {
        return despesaRepository.save(despesa);
    }


}
