package org.example.weblogproducer1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.weblogproducer1.dto.MessageDto;
import org.example.weblogproducer1.service.WebLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class WebLogController {

    private final WebLogService webLogService;

    @Autowired
    public WebLogController(WebLogService webLogService) {
        this.webLogService = webLogService;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody MessageDto message) {
        webLogService.sendMessage(message);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
}
