package ru.aspirkin.telegrambot.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.aspirkin.telegrambot.entities.Category;
import ru.aspirkin.telegrambot.entities.Client;
import ru.aspirkin.telegrambot.entities.ClientOrder;
import ru.aspirkin.telegrambot.entities.Product;
import ru.aspirkin.telegrambot.service.EntitiesService;

/**
 * REST-контроллер приложения
 *
 * @author aspirkin
 * @since 19.05.2022
 */
@RestController
public class applicationRestController
{
    private final EntitiesService entitiesService;

    public applicationRestController(EntitiesService entitiesService)
    {
        this.entitiesService = entitiesService;
    }

    @GetMapping("/rest/clients")
    public List<Client> getAllClients()
    {
        return entitiesService.getAllClients();
    }

    @GetMapping(value = "/rest/clients", params = "id")
    public Client getClientById(@RequestParam Long id)
    {
        return entitiesService.getClientById(id);
    }

    @GetMapping(value = "/rest/clients", params = "name")
    public Client getClientByName(@RequestParam String name)
    {
        return entitiesService.getClientByName(name);
    }

    @GetMapping("/rest/orders")
    public List<ClientOrder> getAllOrders()
    {
        return entitiesService.getAllOrders();
    }

    @GetMapping(value = "/rest/orders", params = "id")
    public ClientOrder getOrderById(@RequestParam Long id)
    {
        return entitiesService.getOrderById(id);
    }

    @GetMapping(value = "/rest/orders", params = "status")
    public List<ClientOrder> getOrdersByStatus(@RequestParam Integer status)
    {
        return entitiesService.getOrdersByStatus(status);
    }

    @GetMapping("/rest/products")
    public List<Product> getAllProducts()
    {
        return entitiesService.getAllProducts();
    }

    @GetMapping(value = "/rest/products", params = "id")
    public Product getProductById(@RequestParam Long id)
    {
        return entitiesService.getProductById(id);
    }

    @GetMapping(value = "/rest/products", params = "name")
    public Product getProductByName(@RequestParam String name)
    {
        return entitiesService.getProductsByName(name);
    }

    @GetMapping(value = "/rest/products", params = "categoryId")
    public List<Product> getProductsByCategory(@RequestParam Long categoryId)
    {
        return entitiesService.getCategoryProducts(categoryId);
    }

    @GetMapping("/rest/categories")
    public List<Category> getAllCategories()
    {
        return entitiesService.getAllCategories();
    }

    @GetMapping(value = "/rest/listClientOrders", params = "clientName")
    public List<ClientOrder> getOrdersByClientName(String clientName)
    {
        return entitiesService.getClientOrdersByName(clientName);
    }

    @GetMapping(value = "/rest/listClientProducts", params = "clientId")
    public List<Product> getClientProductsById(Long clientId)
    {
        return entitiesService.getClientProducts(clientId);
    }

    @GetMapping(value = "/rest/topPopularProducts", params = "top")
    public List<Product> getTopPopularProducts(@RequestParam Integer top)
    {
        return entitiesService.getTopPopularProducts(top);
    }
}