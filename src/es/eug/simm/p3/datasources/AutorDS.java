package es.eug.simm.p3.datasources;

import org.bson.Document;

import com.mongodb.client.MongoDatabase;

public class AutorDS extends MyDataSource {	
	public AutorDS(MongoDatabase database) {
		super(database, "Autors");
	}

	public void insert(String name, String surname) {
		// TODO Auto-generated method stub

		Document document = new Document();
        document.put("name", name);
        document.put("surname", surname);
        
        insert(document);
		
	}

}