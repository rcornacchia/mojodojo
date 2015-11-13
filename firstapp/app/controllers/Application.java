package controllers;

import play.*;
import play.mvc.*;
import models.*;
import play.data.*;


import views.html.*;

public class Application extends Controller {


     public Result index() {


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
