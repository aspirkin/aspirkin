package ru.aspirkin.telegrambot.service;

import java.util.List;

import ru.aspirkin.telegrambot.entities.Category;
import ru.aspirkin.telegrambot.entities.Client;
import ru.aspirkin.telegrambot.entities.ClientOrder;
import ru.aspirkin.telegrambot.entities.Product;

/**
 * Сервис для работы с сущностями телеграмм-бота
 *
 * @author aspirkin
 * @since 19.05.2022
 */
public interface EntitiesService
{
    /**
     * Получить список всех клиентов
     */
    List<Client> getAllClients();

    /**
     * Получить клиента по его идентификатору
     * @param id идентификатор клиента
     */
    Client getClientById(Long id);

    /**
     * Получить клиента по его имени
     * @param name имя клиента
     */
    Client getClientByName(String name);

    /**
     * Получить список всех заказов
     */
    List<ClientOrder> getAllOrders();

    /**
     * Получить заказ по его идентификатору
     * @param id идентификатор заказа
     */
    ClientOrder getOrderById(Long id);

    /**
     * Получить заказ по его статусу
     * @param status статус заказа
     */
    List<ClientOrder> getOrdersByStatus(Integer status);

    /**
     * Получить список всех товаров
     */
    List<Product> getAllProducts();

    /**
     * Получить товар по его идентификатору
     * @param id идентификатор товар
     */
    Product getProductById(Long id);

    /**
     * Получить товар по его описанию
     * @param name описание товара
     */
    Product getProductsByName(String name);

    /**
     * Получить список товаров в категории
     * @param id идентификатор категории
     */
    List<Product> getCategoryProducts(Long id);

    /**
     * Получить список всех категорий
     */
    List<Category> getAllCategories();

    /**
     * Получить список заказов клиента по его имени
     * @param name имя клиента
     */
    List<ClientOrder> getClientOrdersByName(String name);

    /**
     * Получить список всех товаров купленных когда-либо клиентом
     * @param id идентификатор клиента
     */
    List<Product> getClientProducts(Long id);

    /**
     * Получить указанное кол-во самых популярных товаров среди клиентов
     * @param top кол-во товаров
     */
    List<Product> getTopPopularProducts(Integer top);
}
