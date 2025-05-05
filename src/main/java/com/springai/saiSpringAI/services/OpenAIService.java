package com.springai.saiSpringAI.services;

import com.springai.saiSpringAI.model.Answer;
import com.springai.saiSpringAI.model.Question;


public interface OpenAIService {

    String getAnswer(String question);

    Answer getAnswer(Question question);
}
