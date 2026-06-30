package com.ads.trabalho_final_laura.dto;

public class EventoDto {

    private String titulo;
    private String descricao;
    private Double preco;
    private String status;

    EventoDto() {
    }

    public EventoDto(String titulo, String descricao, Double preco, String status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
