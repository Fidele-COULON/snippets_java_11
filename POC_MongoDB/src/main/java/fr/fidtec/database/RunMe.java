package fr.fidtec.database;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

// https://www.baeldung.com/java-mongodb
public class RunMe {

	private static Logger logger = LoggerFactory.getLogger(RunMe.class);
	
	public static void main(String[] args) {
		
		System.out.println("Hello MongoDB World !\n" ); //NOSONAR
		logger.debug("Hello MongoDB World !");

		
		// Make a connection to a MongoDB server
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		// Display databases
		System.out.println("\nDdatabases :" );
		mongoClient.listDatabaseNames().forEach(System.out::println);
		
		// Connect to the database
		MongoDatabase database = mongoClient.getDatabase("test");
		
		// Create a Collection
		database.createCollection("customers");
		
		// Display all existing collections (i.e. tables) for current database
		System.out.println("\nCollections :" );
		database.listCollectionNames().forEach(System.out::println);
		
		// populater la collection 
		// save operation has save-or-update semantics: if an id is present, it performs an update, if not – it does an insert.
		MongoCollection<Document> collection = database.getCollection("customers");
		Document document = new Document();
		document.put("nom", "COULON"); // index doit être en minuscules 
		document.put("prenom", "Fidele");
		collection.insertOne(document);
		
		// save with update semantics, operating on an existing customer
		Document query = new Document();
		query.put("nom", "COULON"); // index doit être en minuscules, sinon creation de doublon

		Document newDocument = new Document();
		newDocument.put("nom", "COULON2");

		Document updateObject = new Document();
		updateObject.put("$set", newDocument);

		collection.updateOne(query, updateObject);
		
		// Read a Document From a Collection
		Document searchQuery = new Document();
		searchQuery.put("nom", "COULON2");
		FindIterable<Document> cursor = collection.find(searchQuery);
		
		try (final MongoCursor<Document> cursorIterator = cursor.cursor()) {
		    while (cursorIterator.hasNext()) {
		        System.out.println(cursorIterator.next());
		    }
		}
		
		// Delete a Document
		Document deleteQuery = new Document();
		deleteQuery.put("name", "COULON2");

		collection.deleteOne(deleteQuery);
		
		
		
	}

}
