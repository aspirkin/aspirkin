package ru.aspirkin.telegrambot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Сущность "Категория товара"
 *
 * @author aspirkin
 * @since 06.05.2022
 */
@Entity
public class Category
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    @ManyToOne
    private Category parent;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Category getParent()
    {
        return parent;
    }

    public void setParent(Category parent)
    {
        this.parent = parent;
    }
}