package edu.caensup.sio.td3.messagerie.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.caensup.sio.td3.messagerie.models.Group;

public interface IGroupDAO extends CrudRepository<Group, Integer> {

}
