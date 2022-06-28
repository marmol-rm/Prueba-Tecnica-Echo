package com.app.pruebaTecnica.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pruebaTecnica.model.PermisoPorRol;

@Repository
public interface PermisosRoleRepository extends JpaRepository<PermisoPorRol, Integer> {

}
