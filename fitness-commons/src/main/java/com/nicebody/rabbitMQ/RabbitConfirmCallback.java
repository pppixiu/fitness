package com.nicebody.rabbitMQ;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.io.IOException;
public class RabbitConfirmCallback implements RabbitTemplate.ConfirmCallback {


    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("(start)生产者消息确认=========================");

        if (!ack) {
            System.out.println("消息可能未到达rabbitmq服务器");
        }
        System.out.println("(end)生产者消息确认=========================");

    }
}
