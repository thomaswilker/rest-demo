package rest.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RestResource;

import rest.demo.model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
	
	@RestResource(path="findyByTitle", rel="findyByTitle", exported=true, description=@Description("Beschreibung"))
	public List<BlogPost> findByTitleContainingIgnoreCase(@Param("title") String title);
}