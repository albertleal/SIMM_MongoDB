package es.eug.simm.p3;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import es.eug.simm.p3.datasources.*;


public class Main {
	
	
    public static void main(String[] args) {
    	
    	//Connecting
        MongoClient mongoClient = MongoClients.create("mongodb+srv://"
    		+Constants.USER+":"+Constants.PWD+"@"+Constants.SERVER+"/"+Constants.DBNAME
    		+"?retryWrites=true&w=majority"
        );

        MongoDatabase database = mongoClient.getDatabase(Constants.DBNAME);
        
        
        //Using our DataSources to do stuff with an autor
        AutorDS autorDataSource = new AutorDS(database);
        
        //Create an Autor
        autorDataSource.insert("Albert", "From Java");
        //Get all Autors
        ArrayList<Document> allAutors = autorDataSource.getAll();

        //Delete the last one
        Document toDelete = allAutors.get(allAutors.size() -1);
        autorDataSource.delete(toDelete);

        //Let's list again
        ArrayList<Document> allAutorsAfterRemoved = autorDataSource.getAll();
        
        //Size of both list have different size
        System.out.println(allAutors.size());
        System.out.println(allAutorsAfterRemoved.size());
        
        
        
        //Using our DataSources, this time a for books
        BookDS booksDataSource = new BookDS(database);
        
        ArrayList<Document> allBooks = booksDataSource.getAll();
        
        
        
        Document myBook = allBooks.get(0);
        
        ArrayList<Document> exemplars = booksDataSource.getExemplars(myBook);
        
        System.out.println(exemplars);
        		
        
        
        
        
    }
}



