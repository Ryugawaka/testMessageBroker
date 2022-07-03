package com.example.sendJson.controller;


import com.example.sendJson.core.JsonSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonSenderController {

    @RequestMapping("/send")
    @PostMapping
    public String jsonSend(String json) {
        try {
            JsonSender jsonSender = new JsonSender();
            jsonSender.send(json);
            return "message sent";
        } catch (Exception e) {
            return "failed to sent the message \nException:" + e.getMessage();
        }
    }
}
