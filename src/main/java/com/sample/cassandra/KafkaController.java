package com.sample.cassandra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Clause;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.sample.demo.Movies;

@RestController
public class KafkaController {
	@Autowired
	Producer producer;
	
	@Autowired
	Session session;
	
	@RequestMapping(value = "/publish")
    public String sendMessageToKafkaTopic(@RequestParam("name") String movieName) {
			
		CassandraOperations template = new CassandraTemplate(session);
		 
		 String[] columns = new String[] {"name", "director", "imdb", "release_year", "rotten_tomatoes"};
		 Select select = QueryBuilder.select(columns).from("MOVIES");
		 Clause clause = QueryBuilder.eq("name", movieName);
		 select.where(clause);
		 List<Movies> movies = template.select(select, Movies.class);
		 
		 Cluster cluster = session.getCluster();
		 session.close();
		 cluster.close();
		 
		 if(movies.size() > 0) {
			 producer.sendMessage(movies.get(0));
			 return "Movie pushed on Kafka topic: " + movieName;
		 }else {
			 return "No Movie found in database by the name of " + movieName;
		 }
		 
					
    }

}
