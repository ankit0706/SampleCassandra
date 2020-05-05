package com.sample.cassandra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sample.demo.Movies;

@Service
public class Producer {
	    private static final String TOPIC = "movies";

	    @Autowired
	    private KafkaTemplate<String, Movies> kafkaTemplate;

	    public void sendMessage(Movies movie) {
	        this.kafkaTemplate.send(TOPIC, movie);
	    }

}
