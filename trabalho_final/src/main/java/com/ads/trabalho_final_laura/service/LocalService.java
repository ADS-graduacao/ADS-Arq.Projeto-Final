package com.ads.trabalho_final_laura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ads.trabalho_final_laura.model.Local;
import com.ads.trabalho_final_laura.repository.LocalRepository;

@Service
public class LocalService {

    @Autowired
    LocalRepository localRepository;

    public ResponseEntity<String> cadastrar(Local local) {
        localRepository.save(local);
        return new ResponseEntity<>("Local cadastrado com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<List<Local>> lista() {
        List<Local> locais = localRepository.findAll();
        return new ResponseEntity<>(locais, HttpStatus.OK);
    }

    public ResponseEntity<String> excluir(Long id) {
        localRepository.deleteById(id);
        return new ResponseEntity<>("Local excluído com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<String> editar(Long id, Local local) {
        local.setId(id);
        localRepository.save(local);
        return new ResponseEntity<>("Local editado com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<Local> buscarPorId(Long id) {
        Local local = localRepository.findById(id).orElse(null);
        if (local == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(local, HttpStatus.OK);
    }

    public ResponseEntity<String> bloquearLocal(Long id) {
        Local local = localRepository.findById(id)
                .orElse(null);
        if (local == null) {
            return new ResponseEntity<>("Local não encontrado!", HttpStatus.NOT_FOUND);
        }
        local.setDisponivel(false);
        localRepository.save(local);
        return new ResponseEntity<>("Local bloqueado com sucesso!", HttpStatus.OK);
    }

}
