package rest.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TodoList extends AbstractEntity {
	
	private String title;
	private Date created = new Date();
	
	@ManyToOne
	private User owner;
	
	@ManyToMany
	private List<User> sharedWith = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="list")
	@OrderColumn(name="position")
	private List<Todo> todoes =  new ArrayList<Todo>();
	
	public TodoList(String title, User user) {
		this.title = title;
		this.owner = user;
	}
}
