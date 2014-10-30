package controllers;

import models.User;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by dordoka on 28/10/14.
 */
public class Users extends Controller {

    public static Result create() {

        Form<User> userForm = Form.form(User.class);

        User user = userForm.bindFromRequest().get();
        Morph.ds.save(user);

        return ok("Created user " + user.username);
    }

    public static Result list() {

        return ok(Json.toJson(User.listAll()));
    }

    public static Result search(String username) {

        return ok(Json.toJson(User.searchUsername(username)));
    }

    public static Result index() {

        return ok(views.html.users.render());
    }
}
