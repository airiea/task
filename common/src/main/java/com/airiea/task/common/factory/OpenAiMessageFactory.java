package com.airiea.task.common.factory;

import com.airiea.openai.model.enums.Role;
import com.airiea.openai.model.resource.Message;

public class OpenAiMessageFactory {

//    public static List<Message> createMessagesForAbilityConfig(AbilityConfig abilityConfig, String prompt) {
//        return List.of(
//                createMessage(Role.system, abilityConfig.getDescription()),
//                createMessage(Role.assistant, abilityConfig.getResponseRequirement()),
//                createMessage(Role.assistant, abilityConfig.getExampleInput()),
//                createMessage(Role.assistant, abilityConfig.getExampleOutput()),
//                createMessage(Role.user, prompt)
//        );
//    }
//
//    public static List<Message> createMessagesForKnowledgeEntries(List<KnowledgeEntry> knowledgeEntries, String prompt) {
//        return Stream.concat(
//                knowledgeEntries.stream()
//                        .map(knowledgeEntry -> createMessage(Role.assistant, knowledgeEntry.getContent())),
//                Stream.of(createMessage(Role.user, prompt))
//        ).collect(Collectors.toList());
//    }

    private static Message createMessage(Role role, String content) {
        Message message = new Message();
        message.setRole(role.name());
        message.setContent(content);
        return message;
    }

}
