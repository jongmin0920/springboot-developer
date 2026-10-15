package me.jmlee.springdeveloper;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.jmlee.springdeveloper.controller.QuizController.Code;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class QuizControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("GET /quiz?code=1 이면 응답 코드는 201, 응답 본문은 Created!")
    void getQuiz1() throws Exception {
        final String url = "/quiz";

        final ResultActions result = mockMvc.perform(get(url).param("code", "1"));

        result.andExpect(status().isCreated())
                .andExpect(content().string("Created!"));
    }

    @Test
    @DisplayName("GET /quiz?code=2 이면 응답 코드는 400, 응답 본문은 Bad Request!")
    void getQuiz2() throws Exception {
        final String url = "/quiz";

        final ResultActions result = mockMvc.perform(get(url).param("code", "2"));

        result.andExpect(status().isBadRequest())
                .andExpect(content().string("Bad Request!"));
    }

    @Test
    @DisplayName("POST /quiz 요청, 요청 바디에 {'value': 1}이면 응답 코드는 403, 응답 본문은 Forbidden!")
    void postQuiz1() throws Exception {
        // 준비 given
        final String url = "/quiz";

        // 실행 when
        final ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new Code(1))));

        // 검증 then
        result.andExpect(status().isForbidden())
                .andExpect(content().string("Forbidden!"));
    }

    @Test
    @DisplayName("POST /quiz 요청, 요청 바디에 {'value': 2}이면 응답 코드는 200, 응답 본문은 OK!")
    void postQuiz2() throws Exception {
        final String url = "/quiz";

        final ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new Code(2))));

        result.andExpect(status().isOk())
                .andExpect(content().string("OK!"));
    }
}