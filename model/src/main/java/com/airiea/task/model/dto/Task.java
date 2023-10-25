package com.airiea.task.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @JsonProperty("task_id")
    String taskId;

    @JsonProperty("knowledge_id")
    String knowledgeId;

    @JsonProperty("entity_id")
    String entityId;

    @JsonProperty("agent_name")
    String agentName;

    @JsonProperty("task_count")
    Integer taskCount;

    String prompt;

    String content;

    String statusCode;

    @JsonProperty("error_code")
    String errorCode;

    @JsonProperty("error_message")
    String errorMessage;

    @JsonProperty("created_date")
    Date createdDate;

    @JsonProperty("updated_date")
    Date updatedDate;
}
