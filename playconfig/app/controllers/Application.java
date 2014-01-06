package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import play.data.*;
import models.*;

public class Application extends Controller {
    
    private static final Form<Proposal> proposal = Form.form(Proposal.class);

    public static Result index() {
    	Proposal keyNote = Proposal.findKeynote();
        return ok(views.html.index.render(keyNote));
    }

    public static Result newProposal() {
        return ok(views.html.newProposal.render(proposal));
    }
    
    public static Result submitProposal() {
    	Form<Proposal> submittedProposal = proposal.bindFromRequest();
    	if(submittedProposal.hasErrors()){
    		return ok(views.html.newProposal.render(submittedProposal));
    	}else{
    		Proposal newProposal = submittedProposal.get();
    		newProposal.save();
    		flash("message","Thank you for submitting a proposal");
    		return redirect(routes.Application.index());
    	}
    }
}
