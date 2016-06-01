package rest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.demo.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}