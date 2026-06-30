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

import com.ads.trabalho_final_laura.model.Evento;
import com.ads.trabalho_final_laura.service.EventoService;

@Controller
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    EventoService eventoService;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrar(@RequestBody Evento evento) {
        return eventoService.cadastrar(evento);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Evento>> listaCompleta() {
        return eventoService.lista();
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable("id") Long id) {
        return eventoService.excluir(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@PathVariable("id") Long id, @RequestBody Evento evento) {
        return eventoService.editar(id, evento);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable("id") Long id) {
        return eventoService.buscarPorId(id);
    }

    @PutMapping("/encerrar/{id}")
    public ResponseEntity<String> encerrarEvento(@PathVariable("id") Long id) {
        return eventoService.encerrarEvento(id);
    }

}
