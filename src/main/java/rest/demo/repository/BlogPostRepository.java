package rest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.demo.model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}