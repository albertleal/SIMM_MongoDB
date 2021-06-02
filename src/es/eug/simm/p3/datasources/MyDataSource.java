package es.eug.simm.p3.datasources;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

abstract class MyDataSource {
	protected MongoCollection<Document> collection = null;
	
	public MyDataSource(MongoDatabase database, String collectionName ) {
		this.collection = database.getCollection(collectionName);
	}
	
	public void delete(Document item) {
		this.collection.deleteOne(item);
	}
	
	public void insert(Document item) {
		this.collection.insertOne(item);
	}
	
	public ArrayList<Document> getAll() {
		
		ArrayList<Document> items = new ArrayList<Document>();
				 
				 
		MongoCursor<Document> cursor; 
        BasicDBObject searchQuery = new BasicDBObject();

        //No search query 
        cursor = collection.find(searchQuery).iterator();

        try {
            while (cursor.hasNext()) {
                Document item = (Document) cursor.next();
                items.add(item);    

                //printing the ID
                System.out.println(item.getObjectId("_id"));
            }
        }
        finally {
            cursor.close();
        }

        return items;
	}
}