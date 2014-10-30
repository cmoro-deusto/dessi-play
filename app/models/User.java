package models;

import controllers.Morph;
import controllers.Users;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.query.Query;

import java.util.List;

/**
 * Created by dordoka on 28/10/14.
 */
@Entity(value = "user", noClassnameStored = true)
public class User {

    @Id
    public ObjectId id;

    @Property
    public String name;

    @Property
    public String last;

    @Property
    public String username;

    @Property
    public String pass;

    public static List<User> listAll() {

        return Morph.ds.find(User.class).asList();
    }

    public static User searchUsername(String username) {

        return Morph.ds.find(User.class).filter("username", username).limit(1).get();
    }

    public static List<User> searchUsers(String search) {

        Query<User> query;

        query = Morph.ds.find(User.class);

        query.or(
                query.criteria("name").containsIgnoreCase(search),
                query.criteria("last").containsIgnoreCase(search),
                query.criteria("username").containsIgnoreCase(search)
        );

        return query.asList();
    }
}
