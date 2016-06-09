package rest.demo;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import rest.demo.model.Todo;
import rest.demo.model.TodoList;
import rest.demo.model.User;
import rest.demo.repository.TodoListRepository;
import rest.demo.repository.TodoRepository;
import rest.demo.repository.UserRepository;

@SpringBootApplication
public class RestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}
	
	@Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/api/**", config);
        
        return new CorsFilter(source);
    }
	
	
	@Bean
	public CommandLineRunner demo(TodoListRepository lists, UserRepository users, TodoRepository todos) {
		return (args) -> {
			
			User u1 = new User("Thomas", "Wilker");
			User u2 = new User("Peter", "Rossa");
			User u3 = new User("Klaus", "Steitz");
			
			users.save(Arrays.asList(u1,u2,u3));
			
			TodoList l1 = new TodoList("Einkaufsliste", u1);
			l1.setSharedWith(Arrays.asList(u2,u3));
			
			Todo t1 = new Todo("Wasser", "Kein Azur", u1, l1);
			Todo t2 = new Todo("Bananen", "", u1, l1);
			
			l1.setTodoes(Arrays.asList(t1,t2));
			
			lists.save(l1);
			
		};
	}
}
