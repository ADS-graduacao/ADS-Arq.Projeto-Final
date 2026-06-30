package com.ads.trabalho_final_laura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ads.trabalho_final_laura.model.Artista;
import com.ads.trabalho_final_laura.service.ArtistaService;

@Controller
@RequestMapping("/artista")
public class ArtistaController {

    @Autowired
    ArtistaService artistaService;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrar(@RequestBody Artista artista) {
        return artistaService.cadastrar(artista);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Artista>> listaCompleta() {
        return artistaService.lista();
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable("id") Long id) {
        return artistaService.excluir(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@PathVariable("id") Long id, @RequestBody Artista artista) {
        return artistaService.editar(id, artista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Artista> buscarPorId(@PathVariable("id") Long id) {
        return artistaService.buscarPorId(id);
    }

    @PutMapping("/atualizar-cache/{id}")
    public ResponseEntity<String> atualizarCache(@PathVariable("id") Long id, @RequestParam Double novoCache) {
        return artistaService.atualizarCache(id, novoCache);
    }

}
