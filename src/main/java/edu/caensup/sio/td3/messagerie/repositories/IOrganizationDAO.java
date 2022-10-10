package edu.caensup.sio.td3.messagerie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.caensup.sio.td3.messagerie.models.Organization;

public interface IOrganizationDAO extends JpaRepository<Organization, Integer> {

}
