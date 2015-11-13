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


    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        return ok();
    }

    public static class Login {
        public String email;
        public String password;
    }
}
