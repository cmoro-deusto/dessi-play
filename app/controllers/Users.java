package controllers;

import models.User;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.ArrayList;

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

    public static Result search() {

        return ok(views.html.search.render());
    }

    public static Result doSearch() {

        DynamicForm searchForm = DynamicForm.form().bindFromRequest();
        String search = searchForm.get("search");

        if (search.isEmpty()) {
            return ok(views.html.search.render());
        } else {
            return ok(Json.toJson(User.searchUsers(search)));
        }
    }

    public static Result index() {

        return ok(views.html.users.render());
    }
}
