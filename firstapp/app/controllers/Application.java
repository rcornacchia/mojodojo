package controllers;

import play.*;
import play.mvc.*;
import models.*;
import play.data.*;
import java.util.*;


import views.html.*;
  


public class Application extends Controller {


     public Result index() {

        List<Users> users = Users.find.all();
        List<Artworks> artworksT = users.get(1).artworks;
        System.out.println("printing in controller, size: " + artworksT.size());
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
