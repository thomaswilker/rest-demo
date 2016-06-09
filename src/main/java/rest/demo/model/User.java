package rest.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class User extends AbstractEntity {

	
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy="owner")
	private Set<TodoList> lists = new HashSet<>();
	
	@ManyToMany(mappedBy="sharedWith")
	private Set<TodoList> sharedLists = new HashSet<>();
	
	@OneToMany(mappedBy="user")
	private Set<Todo> todos = new HashSet<>();
	
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
