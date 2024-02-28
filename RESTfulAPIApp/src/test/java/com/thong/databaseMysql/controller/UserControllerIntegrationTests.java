package com.thong.databaseMysql.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thong.databaseMysql.TestDataUtil;
import com.thong.databaseMysql.domain.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class UserControllerIntegrationTests {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Autowired
    public UserControllerIntegrationTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
        objectMapper = new ObjectMapper();
    }

    @Test
    public void postAuthorReturnHttp201() throws Exception {
        UserEntity author = TestDataUtil.getUserEntityA();
        String json = objectMapper.writeValueAsString(author);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void postAuthorAndReturnEntity() throws Exception {
        UserEntity userEntity = TestDataUtil.getUserEntityA();
        String json = objectMapper.writeValueAsString(userEntity);
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/user")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                ).andExpect(MockMvcResultMatchers.jsonPath("$.fullname").value("Tran Van Thong A"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }
}

