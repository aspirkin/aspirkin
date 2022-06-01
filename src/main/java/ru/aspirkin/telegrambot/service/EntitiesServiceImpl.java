package ru.aspirkin.telegrambot.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import ru.aspirkin.telegrambot.dao.CategoryRepository;
import ru.aspirkin.telegrambot.dao.ClientOrderRepository;
import ru.aspirkin.telegrambot.dao.ClientRepository;
import ru.aspirkin.telegrambot.dao.OrderProductRepository;
import ru.aspirkin.telegrambot.dao.ProductRepository;
import ru.aspirkin.telegrambot.entities.Category;
import ru.aspirkin.telegrambot.entities.Client;
import ru.aspirkin.telegrambot.entities.ClientOrder;
import ru.aspirkin.telegrambot.entities.Product;

/**
 * Реализация {@link EntitiesService}
 *
 * @author aspirkin
 * @since 19.05.2022
 */
@Service
@Transactional
public class EntitiesServiceImpl implements EntitiesService
{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ClientOrderRepository clientOrderRepository;
    @Autowired
    private OrderProductRepository orderProductRepository;

    @Override
    public List<Client> getAllClients()
    {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id)
    {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client getClientByName(String name)
    {
        Client exampleClient = new Client();
        exampleClient.setFullName(name);
        return clientRepository.findOne(Example.of(exampleClient)).orElse(null);
    }

    @Override
    public List<ClientOrder> getAllOrders()
    {
        return clientOrderRepository.findAll();
    }

    @Override
    public ClientOrder getOrderById(Long id)
    {
        return clientOrderRepository.findById(id).orElse(null);
    }

    @Override
    public List<ClientOrder> getOrdersByStatus(Integer status)
    {
        ClientOrder exampleClientOrder = new ClientOrder();
        exampleClientOrder.setStatus(status);
        return clientOrderRepository.findAll(Example.of(exampleClientOrder));
    }

    @Override
    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id)
    {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product getProductsByName(String name)
    {
        Product exampleProduct = new Product();
        exampleProduct.setName(name);
        return productRepository.findOne(Example.of(exampleProduct)).orElse(null);
    }

    @Override
    public List<Product> getCategoryProducts(Long id)
    {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category == null)
        {
            return null;
        }
        Product exampleProduct = new Product();
        exampleProduct.setCategory(category);
        return productRepository.findAll(Example.of(exampleProduct));
    }

    @Override
    public List<Category> getAllCategories()
    {
        return categoryRepository.findAll();
    }

    @Override
    public List<ClientOrder> getClientOrdersByName(String name)
    {
        ClientOrder exampleOrder = new ClientOrder();
        exampleOrder.setClient(getClientByName(name));
        return clientOrderRepository.findAll(Example.of(exampleOrder));
    }

    @Override
    public List<Product> getClientProducts(Long id)
    {
        return productRepository.getAllProductsOrderedByClient(id);
    }

    @Override
    public List<Product> getTopPopularProducts(Integer top)
    {
        return productRepository.getTopPopular().stream().limit(top).collect(Collectors.toList());
    }
}