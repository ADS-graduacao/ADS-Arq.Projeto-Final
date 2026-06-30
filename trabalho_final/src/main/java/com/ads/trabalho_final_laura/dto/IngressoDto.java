package com.ads.trabalho_final_laura.dto;

public class IngressoDto {

    private String tipo;
    private Double valor;
    private Integer quantidade;

    IngressoDto() {
    }

    public IngressoDto(String tipo, Double valor, Integer quantidade) {
        this.tipo = tipo;
        this.valor = valor;
        this.quantidade = quantidade;
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
}
