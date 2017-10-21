package werd;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;
import com.mongodb.BasicDBList;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Werd{

    public String word;
    public String result1;
    public String result2;
    public String result3;
    public String result4;
    public String result5;

    public Werd(String word){
      this.word = word;
      this.results();
    }

    public String getWord(){
      return word;
    }

    public void results(){
      // MongoClient mongoClient = new MongoClient( "ec2-34-207-92-4.compute-1.amazonaws.com" , 27019 );
      MongoClientURI connectionString = new MongoClientURI("mongodb://ec2-34-207-92-4.compute-1.amazonaws.com:27019");
      MongoClient mongoClient = new MongoClient(connectionString);
      MongoDatabase database = mongoClient.getDatabase("word");
      MongoCollection<Document> collection = database.getCollection("words");
      Document myDoc = collection.find(eq("_id","genuine")).first();
      String[] str = myDoc.getString("videoId").split(",");
      result1 = str[0];
      result2 = str[1];
      result3 = str[2];
      // result4 = srch.videoID[3];
      // result5 = srch.videoID[4];
    }

}
