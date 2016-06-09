package rest.demo.model.projection;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import rest.demo.model.TodoList;
import rest.demo.model.Todo;
import rest.demo.model.User;

@Projection(name="details", types = {TodoList.class})
public interface ProjectDetails {

	String getTitle();

	@Value("#{target.user.firstName target.user.lastName}")
	String getUserFullName();
	
	Todo getCategory();
	
}


