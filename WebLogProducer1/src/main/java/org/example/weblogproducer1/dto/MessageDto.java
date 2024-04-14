package org.example.weblogproducer1.dto;

import lombok.Data;

@Data
public class MessageDto {

    private String partition;

    private String message;
}
