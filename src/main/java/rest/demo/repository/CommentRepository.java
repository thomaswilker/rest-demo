package rest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.demo.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}