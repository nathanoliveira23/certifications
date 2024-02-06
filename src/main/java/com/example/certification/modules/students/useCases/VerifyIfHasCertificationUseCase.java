package com.example.certification.modules.students.useCases;

import org.springframework.stereotype.Service;

import com.example.certification.modules.students.dto.VerifyIfHasCertificationDTO;

@Service
public class VerifyIfHasCertificationUseCase {
    public boolean execute(VerifyIfHasCertificationDTO dto) {
        return true;
    }
}
