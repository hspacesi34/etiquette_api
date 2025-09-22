package com.etiquette.Participation;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.etiquette.User.User;


// This will be AUTO IMPLEMENTED by Spring into a Bean called roleRepository
// CRUD refers Create, Read, Update, Delete

public interface ParticipationRepository extends CrudRepository<Participation, Integer> {

    Optional<Participation> findByUser(User user);
}