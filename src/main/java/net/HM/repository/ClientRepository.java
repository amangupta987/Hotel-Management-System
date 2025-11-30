package net.HM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.HM.entity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

}
