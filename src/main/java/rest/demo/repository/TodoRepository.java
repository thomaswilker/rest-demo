package rest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.demo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}