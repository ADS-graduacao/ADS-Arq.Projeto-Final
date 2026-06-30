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

import com.ads.trabalho_final_laura.model.Local;
import com.ads.trabalho_final_laura.service.LocalService;

@Controller
@RequestMapping("/local")
public class LocalController {

    @Autowired
    LocalService localService;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrar(@RequestBody Local local) {
        return localService.cadastrar(local);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Local>> listaCompleta() {
        return localService.lista();
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable("id") Long id) {
        return localService.excluir(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@PathVariable("id") Long id, @RequestBody Local local) {
        return localService.editar(id, local);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Local> buscarPorId(@PathVariable("id") Long id) {
        return localService.buscarPorId(id);
    }

    @PutMapping("/bloquear/{id}")
    public ResponseEntity<String> bloquearLocal(@PathVariable("id") Long id) {
        return localService.bloquearLocal(id);
    }

}
