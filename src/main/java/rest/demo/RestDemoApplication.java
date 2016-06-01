package rest.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import rest.demo.model.Category;
import rest.demo.model.Project;
import rest.demo.model.User;
import rest.demo.repository.ProjectRepository;
import rest.demo.repository.UserRepository;

@SpringBootApplication
public class RestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ProjectRepository projects, UserRepository users) {
		return (args) -> {
			
			Project p = new Project("Testproject");
			Category c = new Category("Test");
			p.setCategory(c);
			User u1 = new User("Thomas", "Wilker");
			User u2 = new User("Peter", "Rossa");
			
			p.getUsers().add(u1);
			
			projects.save(p);
			users.save(u2);
			
		};
	}
}
