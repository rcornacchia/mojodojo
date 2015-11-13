package controllers;

import play.*;
import play.mvc.*;
import models.*;
import play.data.*;
import java.util.*;


import views.html.*;
  


public class Application extends Controller {


     public Result index() {

        //List<Users> users = Users.find.where().orderBy("votes desc").findList();
        //List<Users> users = Users.find.where().orderBy("votes desc").findList();
        List<Artworks> arts = Artworks.find.where().orderBy("votes desc").setMaxRows(9).findList();
        //Artworks[] artArray=new Artworks[9];
        //for (int i=0; i< artArray.length; i++)
        //    artArray[i]=arts.get(i);

        //List<Artworks> artworksT = users.get(1).artworks;
        //System.out.println("printing in controller, size: " + arts.get(0).user.email);
       // for(int i=0;i<artworksT.size();i++){
      //      System.out.println(artworksT.get(i).filePath);
       // } 
         return ok(index.render(arts.get(0),arts.get(0),arts.get(0),arts.get(0),arts.get(0),arts.get(0),arts.get(0),arts.get(0),arts.get(0),Form.form(Index.class)));
     }

    public Result login() {
        return ok(
            login.render(Form.form(Login.class))
        );


    }

    public static class Login {

	    public String email;
	    public String password;
        public String validate() {
            if (Users.authenticate(email, password) == null) {
              return "Invalid user or password";
          }

            return null;
        }
	}
	
	public static class Index {

	    public Long bid;
	    public Long artId;
        
	}

    public Result submitBid(){
        Form<Index> indexForm = Form.form(Index.class).bindFromRequest();
        Long artId=indexForm.get().artId;
        Artworks art=Artworks.find.byId(artId);
        Long bid=indexForm.get().bid;
        if (bid==-1){
            if (art.votedOn==0){
                art.votes++;
                art.votedOn=1;
                art.save();
            }
        }
        else{
            if (art.auction.currentBid<bid){
                art.auction.currentBid=bid;
                art.auction.haveHighBid="Yes";
                art.auction.bidCount++;
                art.auction.save();
            }
        }
        return redirect(
                routes.Application.index()
            );

    }
    
    public Result authenticate() {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            System.out.println("Failure");
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            System.out.println("Success");

            session("email", loginForm.get().email);
            return redirect(
                routes.Application.index()
            );
        }
    }
}
