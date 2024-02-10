package com.example.certification.modules.questions.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.certification.modules.questions.entities.QuestionsEntity;

public interface QuestionRepository extends JpaRepository<QuestionsEntity, UUID> {
    List<QuestionsEntity> findByTecnology(String technology);
}
