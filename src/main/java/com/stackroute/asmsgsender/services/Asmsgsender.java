package com.stackroute.asmsgsender.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.asmsgsender.model.AsMessage;

@Service
public class Asmsgsender {

	private static final Logger log = LoggerFactory.getLogger(Asmsgsender.class);
	
	@Autowired
	private KafkaTemplate<String, AsMessage> kafkaTemplate;
	
	@Value("${as.kafka.topic}")
	String kafkaTopic = "as-level1";
	
	public void send(AsMessage data) {
	    log.info("sending data='{}'", data);
	    
	    kafkaTemplate.send(kafkaTopic, data);
	}
}
