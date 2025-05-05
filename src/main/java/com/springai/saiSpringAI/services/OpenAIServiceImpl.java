package com.springai.saiSpringAI.services;

import com.springai.saiSpringAI.model.Answer;
import com.springai.saiSpringAI.model.Question;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class OpenAIServiceImpl implements OpenAIService {

    private final ChatModel chatModel;

    public OpenAIServiceImpl(ChatModel chatModel) {
        this.chatModel = chatModel;
    }



    @Override
    public Answer getAnswer(Question question) {
        System.out.println("question is "+question);
        //question is Question[question=who is the president of USA]
        System.out.println("question is "+question.question());
        // question is who is the president of USA

        PromptTemplate promptTemplate = new PromptTemplate(question.question());
        Prompt prompt = promptTemplate.create();
        ChatResponse response = chatModel.call(prompt);
        System.out.println("response is "+ response);
        //response is ChatResponse [metadata={ id: chatcmpl-BRu9yp5OwZyyEqpOGL64LNRRECWz3, usage: Usage[completionTokens=31, promptTokens=13, totalTokens=44, promptTokensDetails=PromptTokensDetails[audioTokens=0, cachedTokens=0], completionTokenDetails=CompletionTokenDetails[reasoningTokens=0, acceptedPredictionTokens=0, audioTokens=0, rejectedPredictionTokens=0]], rateLimit: { @type: org.springframework.ai.openai.metadata.OpenAiRateLimit, requestsLimit: 500, requestsRemaining: 499, requestsReset: PT0.12S, tokensLimit: 30000; tokensRemaining: 29991; tokensReset: PT0.018S } }, generations=[Generation[assistantMessage=AssistantMessage [messageType=ASSISTANT, toolCalls=[], textContent=As of my last update, the President of the United States is Joe Biden. He has been in office since January 20, 2021., metadata={refusal=, finishReason=STOP, index=0, id=chatcmpl-BRu9yp5OwZyyEqpOGL64LNRRECWz3, role=ASSISTANT, messageType=ASSISTANT}], chatGenerationMetadata=DefaultChatGenerationMetadata[finishReason='STOP', filters=0, metadata=0]]]]
        return new Answer(response.getResult().getOutput().getContent());
        // Response form api
        //{"answer":"As of my last update, the President of the United States is Joe Biden. He has been in office since January 20, 2021."}


    }

    @Override
    public String getAnswer(String question) {
        System.out.println("question is "+question);
        // question is {"question":"who is the president of USA"}
        PromptTemplate promptTemplate = new PromptTemplate(question);
        // error came here
        // org.stringtemplate.v4.compiler.STException: null
        //         // 1:12: '"who is the president of USA"' came as a complete surprise to me


        /*
         public PromptTemplate(String template) {
        this.templateFormat = TemplateFormat.ST;
        this.dynamicModel = new HashMap();
        this.template = template;

        try {
            this.st = new ST(this.template, '{', '}');
        } catch (Exception var3) {
            throw new IllegalArgumentException("The template string is not valid.", var3);
        }
    }
         */
        Prompt prompt = promptTemplate.create();
        ChatResponse response = chatModel.call(prompt);
        System.out.println("response is "+ response);
        return response.getResult().getOutput().getContent();
    }
}
