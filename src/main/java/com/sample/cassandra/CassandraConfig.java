package com.sample.cassandra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

@Configuration
public class CassandraConfig {
	
	@Bean 
	public Session session() {
	    Cluster cluster = Cluster.builder().withPort(9042).addContactPoint("ec2-52-14-205-45.us-east-2.compute.amazonaws.com")
	    		.withoutJMXReporting().build();
	    //cluster.getConfiguration().getSocketOptions().setReadTimeoutMillis(60000);
	    return cluster.connect("sample_keyspace");
	  }
}
