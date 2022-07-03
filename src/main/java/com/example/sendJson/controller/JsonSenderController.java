package com.example.sendJson.controller;


import com.example.sendJson.rabbitmq.JsonSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonSenderController {

    @RequestMapping("/send")
    @PostMapping
    public String jsonSender(String json) throws Exception{
        JsonSender send = new JsonSender();
        send.send(json);
        return "message sent";
    }
}
