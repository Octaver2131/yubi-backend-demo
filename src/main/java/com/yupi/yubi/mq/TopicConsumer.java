package com.yupi.yubi.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class TopicConsumer {

  private static final String EXCHANGE_NAME = "topic-exchange";

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.exchangeDeclare(EXCHANGE_NAME, "topic");

      // 创建队列
      String queueName1 = "T1_queue";
      channel.queueDeclare(queueName1, true, false, false, null);
      channel.queueBind(queueName1, EXCHANGE_NAME, "#.1.#");

      // 创建队列
      String queueName2 = "T2_queue";
      channel.queueDeclare(queueName2, true, false, false, null);
      channel.queueBind(queueName2, EXCHANGE_NAME, "#.2.#");

      // 创建队列
      String queueName3 = "T3_queue";
      channel.queueDeclare(queueName3, true, false, false, null);
      channel.queueBind(queueName3, EXCHANGE_NAME, "#.3.#");

      System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

      DeliverCallback DeliverCallback1 = (consumerTag, delivery) -> {
          String message = new String(delivery.getBody(), "UTF-8");
          System.out.println(" [1] Received '" +
                  delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");
      };

      DeliverCallback DeliverCallback2 = (consumerTag, delivery) -> {
          String message = new String(delivery.getBody(), "UTF-8");
          System.out.println(" [2] Received '" +
                  delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");
      };

      DeliverCallback DeliverCallback3 = (consumerTag, delivery) -> {
          String message = new String(delivery.getBody(), "UTF-8");
          System.out.println(" [3] Received '" +
                  delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");
      };

      channel.basicConsume(queueName1, true, DeliverCallback1, consumerTag -> {
      });
      channel.basicConsume(queueName2, true, DeliverCallback2, consumerTag -> {
      });
      channel.basicConsume(queueName3, true, DeliverCallback3, consumerTag -> {
      });
  }
}