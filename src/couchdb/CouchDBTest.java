package couchdb;

import java.util.List;
import com.fourspaces.couchdb.Database;
import com.fourspaces.couchdb.Document;
import com.fourspaces.couchdb.Session;
import com.fourspaces.couchdb.ViewResults;
 
public class CouchDBTest {
 
 /*These are the keys of document in couch db*/
 public static final String DOC_KEY_NAME ="name";
  
  
 public static void main(String[] args){
   
  /*Creating a session with couch db running in 5984 port*/
  Session docDbSession = new Session("localhost",5984);
   
  /*Selecting the document database from list of couch database*/
  Database docCouchDb = docDbSession.getDatabase("testjava");
   
  /*Fetching all Document to ViewResult object*/
  ViewResults couchViewResults = docCouchDb.getAllDocuments();
   
  /*Retieving all document as result to a List*/
  List<Document> listDocuments = couchViewResults.getResults();
   
   
  for(Document couchDocument: listDocuments){
    
   String id = couchDocument.getJSONObject().getString("id");
    
   Document docRow = docCouchDb.getDocument(id);
    
   System.out.println("__________START OF DOCUMENT("+docRow.get("_id")+")_________");
    
   if(docRow.containsKey(DOC_KEY_NAME)){
     
    System.out.println("NAME : "+docRow.get(DOC_KEY_NAME));
     
   }
   System.out.println("__________END OF DOCUMENT_________");
    
  }
 }
}