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
        List<Artworks> arts = Artworks.find.where().orderBy("votes desc").findList();

        //List<Artworks> artworksT = users.get(1).artworks;
        System.out.println("printing in controller, size: " + arts.get(0).user.email);
       // for(int i=0;i<artworksT.size();i++){
      //      System.out.println(artworksT.get(i).filePath);
       // } 
         return ok(index.render());
     }

    public Result login() {
        return ok(
            login.render(Form.form(Login.class))
        );
    }





    public static class Login {
        public String email;
        public String password;
    }
}
