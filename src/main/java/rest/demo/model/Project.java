package rest.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Project extends AbstractEntity {
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Category category;
	
	private String title;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<User> users =  new ArrayList<>();

	
	public Project(String title) {
		this.title = title;
	}
}
