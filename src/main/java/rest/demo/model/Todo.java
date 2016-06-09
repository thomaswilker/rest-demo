package rest.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
public class Todo extends AbstractEntity {

	private String title;
	private String note;
	private Date created = new Date();
	private Boolean done = false;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private TodoList list;
		
	@Lob
	@Basic(fetch=FetchType.LAZY)
	protected List<byte[]> files;
	
	public Todo(String title, String note, User user, TodoList list) {
		this.title = title;
		this.note = note;
		this.user = user;
		this.list = list;
	}
	
}
