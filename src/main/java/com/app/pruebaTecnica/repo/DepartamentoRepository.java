package com.app.pruebaTecnica.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pruebaTecnica.model.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

}
