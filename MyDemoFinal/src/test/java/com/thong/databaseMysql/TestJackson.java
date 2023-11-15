package com.thong.databaseMysql;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestJackson {
    @Test
    public void testMarshalling() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

    }
    @Test
    public void testUnMarshalling() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
    }
}
