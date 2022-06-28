package com.app.pruebaTecnica.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pruebaTecnica.model.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

}
