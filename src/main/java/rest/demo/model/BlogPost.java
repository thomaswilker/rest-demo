package rest.demo.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BlogPost extends AbstractEntity {
	
	private String title;
	private Date created = new Date();
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	protected byte[] pic; 
	
	@ManyToOne(cascade=CascadeType.ALL)
	private User user;
	
	@OneToMany(mappedBy="post")
	private Set<Comment> comments =  new HashSet<>();
	
	public BlogPost(String title, User user) {
		this.title = title;
		this.user = user;
	}
}
