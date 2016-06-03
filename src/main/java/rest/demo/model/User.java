package rest.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private Set<BlogPost> posts = new HashSet<>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private Set<Comment> comments = new HashSet<>();
	
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
