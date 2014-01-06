package models;

import javax.persistence.*;
import javax.validation.Valid;

import play.db.ebean.Model;
import play.data.validation.Constraints.*;

@Entity
public class Proposal extends Model {

	@Id
	public Long id;
	
	@Required
	public String title;
	
	@Required
	@MinLength(value = 5)
	@MaxLength(value = 1000)
	@Column(length = 1000)
	public String proposal;
	
	@Required
	public SessionType sesstype = SessionType.OneHourTalk;
	
	public String keywords;
	
	@Required
	public Boolean isapproved = false;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	public Speaker speaker;

	private static Finder<Long,Proposal> find = new Finder<Long,Proposal>(Long.class,Proposal.class);
	public static Proposal findKeynote() {
		return find.where().eq("sesstype",SessionType.Keynote).findUnique();
	}
}
