package com.etiquette.Board;

import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called roleRepository
// CRUD refers Create, Read, Update, Delete

public interface BoardRepository extends CrudRepository<Board, Integer> {


}