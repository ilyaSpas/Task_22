package org.example.weblogconusmer.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageListener {

    @KafkaListener(
            topics = "web_log",
            topicPartitions = @TopicPartition(
                    topic = "web_log",
                    partitions = { "0" }
            ))
    public void listenPartition1(String message) {
        log.info("Получено сообщение {} в партицию №1", message);
    }

    @KafkaListener(
            topics = "web_log",
            topicPartitions = @TopicPartition(
                    topic = "web_log",
                    partitions = { "1" }
            ))
    public void listenPartition2(String message) {
        log.info("Получено сообщение {} в партицию №2", message);
    }

    @KafkaListener(
            topics = "web_log",
            topicPartitions = @TopicPartition(
                    topic = "web_log",
                    partitions = { "2" }
            ))
    public void listenPartition3(String message) {
        log.info("Получено сообщение {} в партицию №3", message);
    }

//    @KafkaListener(
//            topics = "web_log",
//            topicPartitions = @TopicPartition(
//                    topic = "web_log",
//                    partitions = { "0, 1, 3" }
//            ))
//    public void listenPartitions(String message) {
//        log.info("Получено сообщение {}", message);
//    }
}
