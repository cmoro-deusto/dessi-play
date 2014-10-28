package controllers;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Created by dordoka on 28/10/14.
 */
public class Morph {

    static public MongoClient mongo;
    static public Morphia morphia;
    static public Datastore ds;
}
