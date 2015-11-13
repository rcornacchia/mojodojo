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
        arts.get(0).votes=9001;
        arts.get(0).save();
        //Artworks[] artArray=new Artworks[9];
        //for (int i=0; i< artArray.length; i++)
        //    artArray[i]=arts.get(i);

        //List<Artworks> artworksT = users.get(1).artworks;
        //System.out.println("printing in controller, size: " + arts.get(0).user.email);
       // for(int i=0;i<artworksT.size();i++){
      //      System.out.println(artworksT.get(i).filePath);
       // } 
         return ok(index.render(arts.get(0),arts.get(0),arts.get(0),arts.get(0),arts.get(0),arts.get(0),arts.get(0),arts.get(0),arts.get(0)));
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
