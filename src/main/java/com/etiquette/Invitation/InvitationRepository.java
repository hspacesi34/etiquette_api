package com.etiquette.Invitation;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.etiquette.User.User;


// This will be AUTO IMPLEMENTED by Spring into a Bean called roleRepository
// CRUD refers Create, Read, Update, Delete

public interface InvitationRepository extends CrudRepository<Invitation, Integer> {

    Optional<Invitation> findByUserReciever(User user);
    Optional<Invitation> findByStatus(String status);
}