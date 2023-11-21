package com.aguerecoders.agueredockergui.services;

import com.aguerecoders.agueredockergui.entity.UserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONService {

    public static UserEntity JSONValueRetrival(String line) {
        try {
            line = line.replace("[", "");
            line = line.replace("]", "");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(line, UserEntity.class);
        }  catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
