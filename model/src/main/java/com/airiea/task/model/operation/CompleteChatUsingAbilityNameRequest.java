package com.airiea.task.model.operation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompleteChatUsingAbilityNameRequest {
    @JsonProperty("ability_name")
    String abilityName;

    @JsonProperty("input_text")
    String inputText;
}
