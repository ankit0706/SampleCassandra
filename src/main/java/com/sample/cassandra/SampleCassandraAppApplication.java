package com.sample.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleCassandraAppApplication{
	
//	@Autowired
//	Session session;
	
	public static void main(String[] args) {
		SpringApplication.run(SampleCassandraAppApplication.class, args);
		
	}

//	@Override
//	public void run(String... args) throws Exception {
//		 CassandraOperations template = new CassandraTemplate(session);
//		 
//		 String[] columns = new String[] {"name", "director", "imdb", "release_year", "rotten_tomatoes"};
//		 Select select = QueryBuilder.select(columns).from("MOVIES");
//		 List<Movies> movies = template.select(select, Movies.class);
//		 System.out.println("Total movies = " + movies.size());
//		 session.close();
//	}

}
