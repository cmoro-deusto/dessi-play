package controllers;

import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by dordoka on 28/10/14.
 */
public class Users extends Controller {

    public static Result create(String name, String lastname, String username, String pass) {

        User user = new User();
        user.name = name;
        user.last = lastname;
        user.username = username;
        user.pass = pass;
        Morph.ds.save(user);

        return ok("Created user " + username);
    }

    public static Result list() {

        return ok(Json.toJson(User.listAll()));
    }
}
