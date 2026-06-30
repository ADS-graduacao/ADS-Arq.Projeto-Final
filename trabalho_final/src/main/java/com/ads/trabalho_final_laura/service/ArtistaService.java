package com.ads.trabalho_final_laura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ads.trabalho_final_laura.model.Artista;
import com.ads.trabalho_final_laura.repository.ArtistaRepository;

@Service
public class ArtistaService {

    @Autowired
    ArtistaRepository artistaRepository;

    public ResponseEntity<String> cadastrar(Artista artista) {
        artistaRepository.save(artista);
        return new ResponseEntity<>("Artista cadastrado com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<List<Artista>> lista() {
        List<Artista> artistas = artistaRepository.findAll();
        return new ResponseEntity<>(artistas, HttpStatus.OK);
    }

    public ResponseEntity<String> excluir(Long id) {
        artistaRepository.deleteById(id);
        return new ResponseEntity<>("Artista excluído com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<String> editar(Long id, Artista artista) {
        artista.setId(id);
        artistaRepository.save(artista);
        return new ResponseEntity<>("Artista editado com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<Artista> buscarPorId(Long id) {
        Artista artista = artistaRepository.findById(id).orElse(null);
        if (artista == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(artista, HttpStatus.OK);
    }

    public ResponseEntity<String> atualizarCache(Long id, Double novoCache) {
        Artista artista = artistaRepository.findById(id)
                .orElse(null);
        if (artista == null) {
            return new ResponseEntity<>("Artista não encontrado!", HttpStatus.NOT_FOUND);
        }
        artista.setCache(novoCache);
        artistaRepository.save(artista);
        return new ResponseEntity<>("Cachê do artista atualizado com sucesso!", HttpStatus.OK);
    }
}
