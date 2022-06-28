package com.app.pruebaTecnica.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pruebaTecnica.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
