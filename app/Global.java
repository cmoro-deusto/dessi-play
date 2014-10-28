import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import controllers.Morph;
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

            Morph.mongo = new MongoClient("127.0.0.1");
            Morph.morphia = new Morphia();
            Morph.ds = Morph.morphia.createDatastore(Morph.mongo, "test");
            Morph.ds.ensureIndexes();
            Morph.ds.ensureCaps();

        } catch (UnknownHostException uhe) {
            uhe.printStackTrace();
        }
        Logger.info("Application has started");
    }

    public void onStop(Application app) {
        Logger.info("Application is going to shutdown...");
    }
}
