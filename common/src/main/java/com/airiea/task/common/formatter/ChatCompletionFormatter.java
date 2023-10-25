package com.airiea.task.common.formatter;

import com.airiea.openai.model.operation.chat.ChatCompletion;

import java.util.stream.Collectors;

public class ChatCompletionFormatter {

    public static String stringify(ChatCompletion chatCompletion, String delimiter) {
        return chatCompletion.getChoices().stream()
                .map(choice -> choice.getMessage().getContent())
                .collect(Collectors.joining(delimiter));
    }

}
