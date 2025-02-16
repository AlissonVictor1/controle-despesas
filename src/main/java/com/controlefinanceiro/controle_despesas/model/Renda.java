package com.controlefinanceiro.controle_despesas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "rendas") //Nome da Tabela
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // Indica que essa classe representa uma tabela no banco.
public class Renda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String descricao;

    @Column(nullable = false, precision = 10, scale= 2)
    private BigDecimal valor;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoriasRendas categoria;

    @Column(nullable = false)
    private LocalDate data;
}
