package com.ads.trabalho_final_laura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ads.trabalho_final_laura.model.Ingresso;
import com.ads.trabalho_final_laura.repository.IngressoRepository;

@Service
public class IngressoService {

    @Autowired
    IngressoRepository ingressoRepository;

    public ResponseEntity<String> cadastrar(Ingresso ingresso) {
        ingressoRepository.save(ingresso);
        return new ResponseEntity<>("Ingresso cadastrado com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<List<Ingresso>> lista() {
        List<Ingresso> ingressos = ingressoRepository.findAll();
        return new ResponseEntity<>(ingressos, HttpStatus.OK);
    }

    public ResponseEntity<String> excluir(Long id) {
        ingressoRepository.deleteById(id);
        return new ResponseEntity<>("Ingresso excluído com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<String> editar(Long id, Ingresso ingresso) {
        ingresso.setId(id);
        ingressoRepository.save(ingresso);
        return new ResponseEntity<>("Ingresso editado com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<Ingresso> buscarPorId(Long id) {
        Ingresso ingresso = ingressoRepository.findById(id).orElse(null);
        if (ingresso == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(ingresso, HttpStatus.OK);
    }

    public ResponseEntity<String> encerrarVenda(Long id) {
        Ingresso ingresso = ingressoRepository.findById(id)
                .orElse(null);
        if (ingresso == null) {
            return new ResponseEntity<>("Ingresso não encontrado!", HttpStatus.NOT_FOUND);
        }
        ingresso.setVendaAtiva(false);
        ingressoRepository.save(ingresso);
        return new ResponseEntity<>("Venda do ingresso encerrada com sucesso!", HttpStatus.OK);
    }

}
