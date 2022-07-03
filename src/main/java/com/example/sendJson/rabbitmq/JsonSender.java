package com.example.sendJson.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.FileReader;
import java.util.Scanner;

public class JsonSender {

    private final static String QUEUE_NAME = "xml-get";

    public void send() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = jsonString();
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("Sent '" + message + "'");
        }

    }
    public static String jsonString() throws Exception {

        FileReader fileReader = new FileReader("src/main/resources/file.json");
        Scanner scan = new Scanner(fileReader);
        String Jfile ="";
        while (scan.hasNext()){
            Jfile += scan.nextLine() +"\n";
        }
        fileReader.close();
        return Jfile;
    }
}
