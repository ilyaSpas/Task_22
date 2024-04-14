package org.example.weblogproducer1.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.weblogproducer1.dto.MessageDto;
import org.example.weblogproducer1.service.WebLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WebLogServiceImpl implements WebLogService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public WebLogServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(MessageDto message) {
        log.info("Сообщение {} отправленно в партицию {}",
                message.getMessage(), message.getPartition());
        kafkaTemplate.send("web_log",
                Integer.valueOf(message.getPartition()),
                null,
                message.getMessage());
    }
}
