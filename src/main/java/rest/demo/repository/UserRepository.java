package rest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}