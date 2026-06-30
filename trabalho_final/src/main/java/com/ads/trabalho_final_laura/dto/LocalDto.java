package com.ads.trabalho_final_laura.dto;

public class LocalDto {

    private String nome;
    private String cidade;
    private Integer capacidadeMaxima;

    LocalDto() {
    }

    public LocalDto(String nome, String cidade, Integer capacidadeMaxima) {
        this.nome = nome;
        this.cidade = cidade;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(Integer capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }
}
