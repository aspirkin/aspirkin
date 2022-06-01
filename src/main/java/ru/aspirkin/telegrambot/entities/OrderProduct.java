package ru.aspirkin.telegrambot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Сущность "Заказ-товар", связывающая заказы с товарами отношением многие ко многим
 *
 * @author aspirkin
 * @since 06.05.2022
 */
@Entity
public class OrderProduct
{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ClientOrder clientOrder;

    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private Integer countProduct;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public ClientOrder getClientOrder()
    {
        return clientOrder;
    }

    public void setClientOrder(ClientOrder clientOrder)
    {
        this.clientOrder = clientOrder;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public Integer getCountProduct()
    {
        return countProduct;
    }

    public void setCountProduct(Integer countProduct)
    {
        this.countProduct = countProduct;
    }
}