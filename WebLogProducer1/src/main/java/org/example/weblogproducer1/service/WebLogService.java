package org.example.weblogproducer1.service;

import org.example.weblogproducer1.dto.MessageDto;

public interface WebLogService {

    void sendMessage(MessageDto message);
}
