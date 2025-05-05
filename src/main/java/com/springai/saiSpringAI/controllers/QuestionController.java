package com.springai.saiSpringAI.controllers;

import com.springai.saiSpringAI.model.Answer;
import com.springai.saiSpringAI.model.Question;
import com.springai.saiSpringAI.services.OpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class QuestionController {

    private final OpenAIService openAIService;

    public QuestionController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }


    /*
    curl --location 'localhost:9000/ask' \
--header 'Content-Type: application/json' \
--data '{"question":"who is the president of USA"}'
     */
    @PostMapping("/ask")
    public Answer askQuestion(@RequestBody Question question) {
        return openAIService.getAnswer(question);
    }


    /*
    curl --location 'localhost:9000/askStringAnswer' \
--header 'Content-Type: application/json' \
--data '{"question":"who is the president of USA"}'
     */
    @PostMapping("/askStringAnswer")
    public String askQuestion(@RequestBody String question) {
        return openAIService.getAnswer(question);
    }
}
