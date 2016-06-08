package rest.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends AbstractEntity {

	private String title;
	private String content;
	private Date created = new Date();
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private BlogPost post;
}
