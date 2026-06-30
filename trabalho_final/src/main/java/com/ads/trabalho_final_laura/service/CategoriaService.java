package com.ads.trabalho_final_laura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ads.trabalho_final_laura.model.Categoria;
import com.ads.trabalho_final_laura.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public ResponseEntity<String> cadastrar(Categoria categoria) {
        categoriaRepository.save(categoria);
        return new ResponseEntity<>("Categoria cadastrada com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<List<Categoria>> lista() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    public ResponseEntity<String> excluir(Long id) {
        categoriaRepository.deleteById(id);
        return new ResponseEntity<>("Categoria excluída com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<String> editar(Long id, Categoria categoria) {
        categoria.setId(id);
        categoriaRepository.save(categoria);
        return new ResponseEntity<>("Categoria editada com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<Categoria> buscarPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        if (categoria == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    public ResponseEntity<String> alterarStatus(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElse(null);
        if (categoria == null) {
            return new ResponseEntity<>("Categoria não encontrada!", HttpStatus.NOT_FOUND);
        }
        categoria.setStatus(!categoria.getStatus());
        categoriaRepository.save(categoria);
        return new ResponseEntity<>("Status da categoria alterado com sucesso!", HttpStatus.OK);
    }

}
