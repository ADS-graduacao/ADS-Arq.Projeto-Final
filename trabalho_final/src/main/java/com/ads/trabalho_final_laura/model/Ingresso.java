package com.ads.trabalho_final_laura.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private Double valor;
    private Integer quantidade;
    private Date dataValidade;
    private Boolean vendaAtiva;

    Ingresso() {
    }

    Ingresso(String tipo, Double valor, Integer quantidade, Date dataValidade, Boolean vendaAtiva) {
        this.tipo = tipo;
        this.valor = valor;
        this.quantidade = quantidade;
        this.dataValidade = dataValidade;
        this.vendaAtiva = vendaAtiva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Boolean getVendaAtiva() {
        return vendaAtiva;
    }

    public void setVendaAtiva(Boolean vendaAtiva) {
        this.vendaAtiva = vendaAtiva;
    }

}
