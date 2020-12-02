package com.example.spring.exercise.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/testRedis")
public class testRedisController {
    private static final Logger LOGGER = LoggerFactory.getLogger(testRedisController.class);

    public testRedisController() {
        LOGGER.info("enter testRedisController.class");
    }

    private StringRedisTemplate template;
    private MessageListenerAdapter listenerAdapter;
    private RedisMessageListenerContainer container;
    private Receiver receiver;

    public StringRedisTemplate getTemplate() {
        return template;
    }

    public void setTemplate(StringRedisTemplate template) {
        this.template = template;
    }

    public MessageListenerAdapter getListenerAdapter() {
        return listenerAdapter;
    }

    public void setListenerAdapter(MessageListenerAdapter listenerAdapter) {
        this.listenerAdapter = listenerAdapter;
    }

    public RedisMessageListenerContainer getContainer() {
        return container;
    }

    public void setContainer(RedisMessageListenerContainer container) {
        this.container = container;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Bean
    public StringRedisTemplate template2(RedisConnectionFactory connectionFactory) {
        LOGGER.info("enter template");
        setTemplate(new StringRedisTemplate(connectionFactory));
        return getTemplate();
    }

    @Bean
    StringRedisTemplate template4(RedisConnectionFactory connectionFactory) {
        LOGGER.info("enter template");
        return new StringRedisTemplate(connectionFactory);
    }
    @Bean
    public MessageListenerAdapter listenerAdapter2(Receiver receiver) {
        LOGGER.info("enter listenerAdapter");
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    public RedisMessageListenerContainer container2(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        LOGGER.info("enter container");
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
        return container;
    }
    @Bean
    public Receiver receiver2() {
        LOGGER.info("enter receiver");
        return new Receiver();
    }


    @GetMapping(path="")
    public void testRedis() throws InterruptedException {
        StringRedisTemplate template = getTemplate();
        LOGGER.info("enter main2");
        Receiver receiver = getReceiver();
        LOGGER.info("enter main3");
        while (receiver.getCount() == 0) {
            LOGGER.info("Sending message...");
            template.convertAndSend("chat", "Hello from Redis!");
            Thread.sleep(500L);
        }
    }
}
