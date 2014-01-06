package models;

import javax.persistence.*;
import play.db.ebean.Model;
import play.data.validation.Constraints.*;

@Entity
public class Speaker extends Model {

	@Id
	public Long id;
	
	@Required
	public String name;
	
	@Required
	@MinLength(value = 10)
	@MaxLength(value = 1000)
	@Column(length = 1000)
	public String bio;
	
	@Required
	@Email
	public String email;
	
	public String twitterid;
	
	public String pictureurl;
}
