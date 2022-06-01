package ru.aspirkin.telegrambot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ru.aspirkin.telegrambot.entities.OrderProduct;

/**
 * Репозиторй сущности "Заказ-товар"
 *
 * @author aspirkin
 * @since 06.05.2022
 */
@RepositoryRestResource(path = "orderProducts", collectionResourceRel = "orderProducts")
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long>
{
}