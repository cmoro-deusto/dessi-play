package models;

import controllers.Morph;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

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
}
