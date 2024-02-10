package com.example.certification.modules.questions.dto;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAlternativeResultDTO {
    private UUID id;
    private String technology;
    private String description;

    List<AlterternativesResultDTO> alternatives;
}
