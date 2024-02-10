package com.example.certification.modules.students.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.certification.modules.students.dto.VerifyIfHasCertificationDTO;
import com.example.certification.modules.students.repository.CertificationStudentRepository;

@Service
public class VerifyIfHasCertificationUseCase {
    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    public boolean execute(VerifyIfHasCertificationDTO dto) {
        var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());

        return result.isEmpty() ? false : true;
    }
}
