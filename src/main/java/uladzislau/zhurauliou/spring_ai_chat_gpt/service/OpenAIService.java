package uladzislau.zhurauliou.spring_ai_chat_gpt.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import uladzislau.zhurauliou.spring_ai_chat_gpt.dto.Answer;
import uladzislau.zhurauliou.spring_ai_chat_gpt.dto.Question;

@Service
public class OpenAIService {

    private final ChatClient client;

    public OpenAIService(ChatClient.Builder builder) {
        this.client = builder
                .build();
    }

    public Answer getAnswer(Question question) {
        return client.prompt()
                .user(question.question())
                .call()
                .entity(Answer.class);
    }

}
