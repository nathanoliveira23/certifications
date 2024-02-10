package com.example.certification.modules.questions.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.certification.modules.questions.dto.AlternativesResultDTO;
import com.example.certification.modules.questions.dto.QuestionAlternativeResultDTO;
import com.example.certification.modules.questions.entities.AlternativesEntity;
import com.example.certification.modules.questions.entities.QuestionsEntity;
import com.example.certification.modules.questions.repository.QuestionRepository;

@RestController
@RequestMapping("/questions")
public class QuestionsController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("technology/{technology}")
    public List<QuestionsEntity> findByTecnology(@PathVariable String technology) {
        var result = this.questionRepository.findByTechnology(technology);

        var toMap = result.stream().map(question -> mapQuestionToDTO(question))
                .collect(Collectors.toList());
        return toMap;
    }

    static QuestionAlternativeResultDTO mapQuestionToDTO(QuestionsEntity question) {
        var questionResultDTO = QuestionAlternativeResultDTO.builder().id(question.getId())
                                                                    .technology(question.getTechnology())
                                                                    .description(question.getDescription())
                                                                    .builder();

        List<AlternativesResultDTO> alternativesResultDTOs = question.getAlternatives().stream()
                                                                                    .map(alternative -> mapAlternativeDTO(alternative))
                                                                                    .collect(Collectors.toList());

        questionResultDTO.setAlternatives(alternativesResultDTOs);

        return questionResultDTO;
    }

    static AlternativesResultDTO mapAlternativeDTO(AlternativesEntity alternativesResultDTO) {
        return AlternativesResultDTO.builder()
                .id(alternativesResultDTO.getId())
                .description(alternativesResultDTO.getDescription()).build();
    }
} 
