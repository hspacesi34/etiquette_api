package com.etiquette.BoardColumn;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called roleRepository
// CRUD refers Create, Read, Update, Delete

public interface BoardColumnRepository extends CrudRepository<BoardColumn, Integer> {

    Optional<BoardColumn> findByName(String name);
}