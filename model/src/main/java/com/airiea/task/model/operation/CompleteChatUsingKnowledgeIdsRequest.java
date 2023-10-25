package com.airiea.task.model.operation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompleteChatUsingKnowledgeIdsRequest {
    String model;

    @JsonProperty("response_delimiter")
    String responseDelimiter;

    Double temperature;

    @JsonProperty("max_tokens")
    Integer maxTokens;

    @JsonProperty("prompt")
    String prompt;

    @JsonProperty("knowledge_ids")
    List<String> knowledgeIds;
}
