package com.ads.trabalho_final_laura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ads.trabalho_final_laura.model.Evento;
import com.ads.trabalho_final_laura.repository.EventoRepository;

@Service
public class EventoService {

    @Autowired
    EventoRepository eventoRepository;

    public ResponseEntity<String> cadastrar(Evento evento) {
        eventoRepository.save(evento);
        return new ResponseEntity<>("Evento cadastrado com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<List<Evento>> lista() {
        List<Evento> eventos = eventoRepository.findAll();
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    public ResponseEntity<String> excluir(Long id) {
        eventoRepository.deleteById(id);
        return new ResponseEntity<>("Evento excluído com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<String> editar(Long id, Evento evento) {
        evento.setId(id);
        eventoRepository.save(evento);
        return new ResponseEntity<>("Evento editado com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<Evento> buscarPorId(Long id) {
        Evento evento = eventoRepository.findById(id).orElse(null);
        if (evento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }

    public ResponseEntity<String> encerrarEvento(Long id) {
        Evento evento = eventoRepository.findById(id)
                .orElse(null);
        if (evento == null) {
            return new ResponseEntity<>("Evento não encontrado!", HttpStatus.NOT_FOUND);
        }
        evento.setStatus("ENCERRADO");
        eventoRepository.save(evento);
        return new ResponseEntity<>("Evento encerrado com sucesso!", HttpStatus.OK);
    }

}
