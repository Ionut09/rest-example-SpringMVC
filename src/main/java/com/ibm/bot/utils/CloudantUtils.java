package com.ibm.bot.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map.Entry;
import java.util.Set;

import com.cloudant.client.api.*;
import com.cloudant.client.org.lightcouch.CouchDbException;
import com.google.gson.*;
import static com.ibm.bot.utils.Constants.*;

public class CloudantUtils{

	private static CloudantClient cloudant = null;
	private static Database db = null;

	private static void initClient() {
		if (cloudant == null) {
			synchronized (CloudantUtils.class) {
				if (cloudant != null) {
					return;
				}
				cloudant = createClient();

			}
		}
	}

	private static CloudantClient createClient() {
		String VCAP_SERVICES = System.getenv("VCAP_SERVICES");
		String serviceName = null;

		if (VCAP_SERVICES != null) {
			// When running in Bluemix, the VCAP_SERVICES env var will have the credentials for all bound/connected services
			// Parse the VCAP JSON structure looking for cloudant.
			JsonObject obj = (JsonObject) new JsonParser().parse(VCAP_SERVICES);
			Entry<String, JsonElement> dbEntry = null;
			Set<Entry<String, JsonElement>> entries = obj.entrySet();
			// Look for the VCAP key that holds the cloudant no sql db information
			for (Entry<String, JsonElement> eachEntry : entries) {
				if (eachEntry.getKey().toLowerCase().contains("cloudant")) {
					dbEntry = eachEntry;
					break;
				}
			}
			if (dbEntry == null) {
				throw new RuntimeException("Could not find cloudantNoSQLDB key in VCAP_SERVICES env variable");
			}

			obj = (JsonObject) ((JsonArray) dbEntry.getValue()).get(0);
			serviceName = (String) dbEntry.getKey();
			System.out.println("Service Name - " + serviceName);

			obj = (JsonObject) obj.get("credentials");

			db_user = obj.get("username").getAsString();
			db_password = obj.get("db_password").getAsString();

		} else {
			System.out.println("VCAP_SERVICES env var doesn't exist: running locally.");
		}

		try {
			System.out.println("Connecting to Cloudant : " + db_user);
			CloudantClient client = ClientBuilder.url(new URL(DATABASE_URL))
												.username(db_user)
												.password(db_password)
												.build();
			return client;
		} catch (CouchDbException e) {
			throw new RuntimeException("Unable to connect to repository", e);
		} catch (MalformedURLException e) {
			throw new RuntimeException("There is a problem with the URL", e);
		}
	}

	public static Database getDB() {
		if (cloudant == null) {
			initClient();
		}

		if (db == null) {
			try {
				db = cloudant.database(DATABASE_NAME, true);
			} catch (Exception e) {
				throw new RuntimeException("DB Not found", e);
			}
		}
		return db;
	}

	private CloudantUtils() {
		
	}
}
