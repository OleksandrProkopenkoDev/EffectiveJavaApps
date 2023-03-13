package net.javaguides.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
