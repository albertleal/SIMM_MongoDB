package es.eug.simm.p3.datasources;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoDatabase;

public class BookDS extends MyDataSource {

	public BookDS(MongoDatabase database) {
		super(database, "Books");
	}

	
	public ArrayList<Document> getExemplars(Document book) {
		
		ArrayList<Document> exemplars = (ArrayList<Document>) book.get("exemplars");
		 
        for (Document doc : exemplars) {
           System.out.println("Exemplar: "+doc.get("num"));
         }
		
		
		return exemplars;
	}
	
}
