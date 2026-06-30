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

import com.ads.trabalho_final_laura.model.Ingresso;
import com.ads.trabalho_final_laura.service.IngressoService;

@Controller
@RequestMapping("/ingresso")
public class IngressoController {

    @Autowired
    IngressoService ingressoService;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrar(@RequestBody Ingresso ingresso) {
        return ingressoService.cadastrar(ingresso);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Ingresso>> listaCompleta() {
        return ingressoService.lista();
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable("id") Long id) {
        return ingressoService.excluir(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@PathVariable("id") Long id, @RequestBody Ingresso ingresso) {
        return ingressoService.editar(id, ingresso);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Ingresso> buscarPorId(@PathVariable("id") Long id) {
        return ingressoService.buscarPorId(id);
    }

    @PutMapping("/encerrar-venda/{id}")
    public ResponseEntity<String> encerrarVenda(@PathVariable("id") Long id) {
        return ingressoService.encerrarVenda(id);
    }

}
