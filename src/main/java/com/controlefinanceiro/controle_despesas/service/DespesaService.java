package com.controlefinanceiro.controle_despesas.service;

import com.controlefinanceiro.controle_despesas.model.Despesa;
import com.controlefinanceiro.controle_despesas.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {
    @Autowired //Injeção de dependência do repositório para acessar o banco de dados
    private DespesaRepository despesaRepository;

    // Método para listar todas as despesas
    public List<Despesa> listarDespesas() {
        return despesaRepository.findAll(); // Retorna todas as despesas do banco
    }

    // Método para buscar uma despesa pelo ID
    public Optional<Despesa> buscarDespesaPorId(Long id) {
        return despesaRepository.findById(id); // Retorna a despesa com o ID especificado
    }

    // Método para criar uma nova despesa
    public Despesa criarDespesa(Despesa despesa) {
        return despesaRepository.save(despesa); // Salva a despesa no banco
    }

    // Método para atualizar uma despesa existente
    public Despesa atualizarDespesa(Long id, Despesa novaDespesa) {
        // Verifica se a despesa existe no banco
        Optional<Despesa> despesaExistente = despesaRepository.findById(id);

        if (despesaExistente.isPresent()) {
            Despesa despesaAtualizada = despesaExistente.get();
            despesaAtualizada.setDescricao(novaDespesa.getDescricao());
            despesaAtualizada.setValor(novaDespesa.getValor());
            despesaAtualizada.setData(novaDespesa.getData());

            return despesaRepository.save(despesaAtualizada); // Atualiza e salva no banco
        } else {
            throw new IllegalArgumentException("Despesa não encontrada para atualização.");
        }
    }
}
