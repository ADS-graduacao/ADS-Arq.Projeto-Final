package com.ads.trabalho_final_laura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ads.trabalho_final_laura.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

}
