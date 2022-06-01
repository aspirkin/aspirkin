package ru.aspirkin.telegrambot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ru.aspirkin.telegrambot.entities.Client;

/**
 * Репозиторий сущности "Клиент"
 *
 * @author aspirkin
 * @since 06.05.2022
 */
@RepositoryRestResource(path = "clients", collectionResourceRel = "clients")
public interface ClientRepository extends JpaRepository<Client, Long>
{
}