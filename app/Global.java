import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import models.User;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import play.*;

import java.net.UnknownHostException;

/**
 * Created by dordoka on 28/10/14.
 */
public class Global extends GlobalSettings {

    public void onStart(Application app) {

        try {
            Logger.info("Initializing MongoDB");
            MongoClient mongo = new MongoClient("127.0.0.1");
            Morphia morph = new Morphia();
            Datastore ds = morph.createDatastore(mongo, "test");
            ds.ensureIndexes();
            ds.ensureCaps();


            Logger.debug("Inserting user");

            User usr = new User();
            usr.name = "John";
            usr.last = "Snow";
            usr.username = "jsnow";
            usr.pass = "iknownothing";
            ds.save(usr);

        } catch (UnknownHostException uhe) {
            uhe.printStackTrace();
        }
        Logger.info("Application has started");
    }

    public void onStop(Application app) {
        Logger.info("Application is going to shutdown...");
    }
}
