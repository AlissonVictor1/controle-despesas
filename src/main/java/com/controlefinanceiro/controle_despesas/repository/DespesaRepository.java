package com.controlefinanceiro.controle_despesas.repository;


import com.controlefinanceiro.controle_despesas.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// interação com o banco de dados
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

}
