package com.app.pruebaTecnica.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pruebaTecnica.model.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Integer> {

}
