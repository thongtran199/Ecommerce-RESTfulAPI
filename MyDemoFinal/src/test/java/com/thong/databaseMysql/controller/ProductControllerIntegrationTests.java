package com.thong.databaseMysql.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thong.databaseMysql.TestDataUtil;
import com.thong.databaseMysql.domain.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
public class ProductControllerIntegrationTests {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Autowired
    public ProductControllerIntegrationTests(MockMvc mockMvc)
    {
    objectMapper = new ObjectMapper();
    this.mockMvc = mockMvc;

    }
    @Test
    public void testThatPutMappingReturnSavedBook() throws Exception
    {
        ProductDto productDto = TestDataUtil.getProductDtoA();
        String result = objectMapper.writeValueAsString(productDto);
        mockMvc.perform(
                MockMvcRequestBuilders.put("/product/"+productDto.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(result)
        ).andExpect(MockMvcResultMatchers.status().isCreated());

    }
}
