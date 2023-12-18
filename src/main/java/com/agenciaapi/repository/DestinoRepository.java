package com.agenciaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenciaapi.model.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {

}
