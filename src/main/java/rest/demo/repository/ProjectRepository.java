package rest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.demo.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}