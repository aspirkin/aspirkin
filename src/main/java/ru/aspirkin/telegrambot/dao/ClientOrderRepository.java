package ru.aspirkin.telegrambot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ru.aspirkin.telegrambot.entities.ClientOrder;

/**
 * Репозиторий сущности "Заказ клиента"
 *
 * @author aspirkin
 * @since 06.05.2022
 */
@RepositoryRestResource(path = "clientOrders", collectionResourceRel = "clientOrders")
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long>
{
}