package marius.ma.todoappandgithubactions.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import marius.ma.todoappandgithubactions.dto.TaskDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class TaskControllerTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void fullCrudFlow() throws Exception {
        TaskDto create = new TaskDto(null, "Test title", "Test description", false);
        String body = objectMapper.writeValueAsString(create);

        String location = mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", startsWith("/tasks/")))
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.title", is("Test title")))
                .andReturn()
                .getResponse()
                .getHeader("Location");

        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", not(empty())));

        TaskDto update = new TaskDto(null, "Updated title", "Updated desc", true);
        assert location != null;
        mockMvc.perform(put(location)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Updated title")))
                .andExpect(jsonPath("$.description", is("Updated desc")))
                .andExpect(jsonPath("$.done", is(true)));

        mockMvc.perform(delete(location))
                .andExpect(status().isNoContent());

        mockMvc.perform(delete(location))
                .andExpect(status().isNotFound());
    }
}
