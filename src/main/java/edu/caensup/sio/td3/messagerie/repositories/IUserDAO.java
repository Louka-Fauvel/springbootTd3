package edu.caensup.sio.td3.messagerie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.caensup.sio.td3.messagerie.models.User;

public interface IUserDAO extends JpaRepository<User, Integer> {

}
