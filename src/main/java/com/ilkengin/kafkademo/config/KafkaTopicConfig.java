package com.ilkengin.kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.ilkengin.kafkademo.constant.KafkaTopics;

@Configuration
class KafkaTopicConfig {

  @Bean
  public NewTopic userCreatedTopic() {
    return TopicBuilder.name(KafkaTopics.USER_CREATED_TOPIC).build();
  }

  @Bean
  public NewTopic userRemovedTopic() {
    return TopicBuilder.name(KafkaTopics.USER_REMOVED_TOPIC).build();
  }
}