package com.ilkengin.kafkademo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ilkengin.kafkademo.constant.KafkaTopics;

@RestController("/v1/users")
public class UserController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@PostMapping("create")
	public void createUser() {
		// TODO: Create User
		sendMessage(KafkaTopics.USER_CREATED_TOPIC, UUID.randomUUID().toString());
	}
	
	@PostMapping("remove")
	public void removeUser(@RequestBody String userId) {
		// TODO: Remove User
		sendMessage(KafkaTopics.USER_REMOVED_TOPIC, userId);
	}
	
	private void sendMessage(String topic, String message) {
		kafkaTemplate.send(topic, message);
	}
}
