package com.controlefinanceiro.controle_despesas.service;

import com.controlefinanceiro.controle_despesas.model.Renda;
import com.controlefinanceiro.controle_despesas.repository.RendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RendaService {
    @Autowired
    private RendaRepository rendaRepository;

    public List<Renda> listarRendas() {
        return rendaRepository.findAll();
    }

    public Optional<Renda> buscarRendaPorId(Long id) {
        return rendaRepository.findById(id);
    }

    public Renda criarRenda(Renda renda) {
        return rendaRepository.save(renda);
    }

    public Renda atualizarRenda(Long id, Renda novaRenda) {
        Optional<Renda> rendaExistente = rendaRepository.findById(id);
        if (rendaExistente.isPresent()) {
            Renda rendaAtualizada = rendaExistente.get();
            rendaAtualizada.setDescricao(novaRenda.getDescricao());
            rendaAtualizada.setValor(novaRenda.getValor());
            rendaAtualizada.setData(novaRenda.getData());
            return rendaRepository.save(rendaAtualizada);
        } else {
            throw new IllegalArgumentException("Renda não encontrada para atualização.");
        }
    }
}
