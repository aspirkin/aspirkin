package ru.aspirkin.telegrambot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ru.aspirkin.telegrambot.entities.Category;

/**
 * Репозиторий сущности "Категория"
 *
 * @author aspirkin
 * @since 06.05.2022
 */
@RepositoryRestResource(path = "categories", collectionResourceRel = "categories")
public interface CategoryRepository extends JpaRepository<Category, Long>
{
}