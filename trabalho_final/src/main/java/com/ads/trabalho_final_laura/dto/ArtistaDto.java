package com.ads.trabalho_final_laura.dto;

public class ArtistaDto {

    private String nome;
    private String genero;
    private String bio;

    ArtistaDto() {
    }

    public ArtistaDto(String nome, String genero, String bio) {
        this.nome = nome;
        this.genero = genero;
        this.bio = bio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

}
