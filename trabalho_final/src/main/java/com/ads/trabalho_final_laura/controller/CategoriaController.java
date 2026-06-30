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

import com.ads.trabalho_final_laura.model.Categoria;
import com.ads.trabalho_final_laura.service.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrar(@RequestBody Categoria categoria) {
        return categoriaService.cadastrar(categoria);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Categoria>> listaCompleta() {
        return categoriaService.lista();
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable("id") Long id) {
        return categoriaService.excluir(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@PathVariable("id") Long id, @RequestBody Categoria categoria) {
        return categoriaService.editar(id, categoria);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable("id") Long id) {
        return categoriaService.buscarPorId(id);
    }

    @PutMapping("/alterar-status/{id}")
    public ResponseEntity<String> alterarStatus(@PathVariable("id") Long id) {
        return categoriaService.alterarStatus(id);
    }

}
