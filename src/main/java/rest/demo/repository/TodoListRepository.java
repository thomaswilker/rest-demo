package rest.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import rest.demo.model.TodoList;
import rest.demo.model.User;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {
	
	@RestResource(path="findyByTitle", rel="findyByTitle")
	public Page<TodoList> findByTitleContainingIgnoreCase(@Param("title") String title, Pageable pageable);
	
	@RestResource(path="findyByOwner", rel="findyByOwner")
	public Page<TodoList> findByOwner(@Param("owner") User owner, Pageable pageable);
	
}