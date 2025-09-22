package com.etiquette.Role;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called roleRepository
// CRUD refers Create, Read, Update, Delete

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Optional<Role> findByName(String name);
}