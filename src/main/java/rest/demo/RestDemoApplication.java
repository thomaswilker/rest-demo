package rest.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import rest.demo.model.BlogPost;
import rest.demo.model.Comment;
import rest.demo.model.User;
import rest.demo.repository.BlogPostRepository;
import rest.demo.repository.CommentRepository;
import rest.demo.repository.UserRepository;

@SpringBootApplication
public class RestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}
	
	
	@Bean
	public FilterRegistrationBean commonsRequestLoggingFilter()
	{
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new CORSFilter());
		return registrationBean;
	}
	
	@Bean
	public CommandLineRunner demo(BlogPostRepository posts, UserRepository users, CommentRepository comments) {
		return (args) -> {
			
			User u1 = new User("Thomas", "Wilker");
			BlogPost p = new BlogPost("Testproject", u1);
			
			posts.save(p);
			
			User u2 = new User("Peter", "Rossa");
			users.save(u2);
			
			Comment c = new Comment();
			c.setContent("Das ist mein Kommentar");
			c.setPost(p);
			c.setTitle("Super!");
			c.setUser(u2);
			
			comments.save(c);
		};
	}
}
