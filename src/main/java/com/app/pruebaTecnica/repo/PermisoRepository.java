package com.app.pruebaTecnica.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pruebaTecnica.model.Permiso;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Integer> {

}
