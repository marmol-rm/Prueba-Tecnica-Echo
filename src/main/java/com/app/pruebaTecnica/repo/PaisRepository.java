package com.app.pruebaTecnica.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pruebaTecnica.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {

}
