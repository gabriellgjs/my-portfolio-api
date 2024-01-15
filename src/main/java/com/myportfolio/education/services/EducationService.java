package com.myportfolio.education.services;

import com.myportfolio.developer.models.Developer;
import com.myportfolio.developer.repositories.DeveloperRepository;
import com.myportfolio.education.dtos.EducationDTO;
import com.myportfolio.education.factories.EducationFactory;
import com.myportfolio.education.models.Education;
import com.myportfolio.education.repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {

  @Autowired
  private EducationRepository educationRepository;

  @Autowired
  private DeveloperRepository developerRepository;

  @Autowired
  private EducationFactory educationFactory;

  public List<Education> getAllEducation() {
    return this.educationRepository.findAll();
  }

  public List<Education> getEducationByDeveloperId(Long id) {
    return this.educationRepository.findByDeveloperId(id);
  }

  public Education createEducation(EducationDTO data) throws Exception {
    Optional<Developer> developer = this.developerRepository.findById(data.developerId());

    if(developer.isEmpty()){
      throw new Exception("Desenvolvedor não encontrado");
    }

    Education newEducation = this.educationFactory.createEducation(data, developer.get());

    this.educationRepository.save(newEducation);

    return newEducation;
  }
}
