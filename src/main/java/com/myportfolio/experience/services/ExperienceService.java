package com.myportfolio.experience.services;

import com.myportfolio.developer.models.Developer;
import com.myportfolio.developer.repositories.DeveloperRepository;
import com.myportfolio.experience.dtos.ExperienceDTO;
import com.myportfolio.experience.factories.ExperienceFactory;
import com.myportfolio.experience.models.Experience;
import com.myportfolio.experience.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {

  @Autowired
  private ExperienceRepository experienceRepository;

  @Autowired
  private DeveloperRepository developerRepository;

  @Autowired
  private ExperienceFactory experienceFactory;

  public List<Experience> getAllExperiences() {
    return this.experienceRepository.findAll();
  }

  public Experience createExperience(ExperienceDTO data) throws Exception {
    Optional<Developer> developer = this.developerRepository.findById(data.developerId());

    if(developer.isEmpty()){
      throw new Exception("Desenvolvedor não encontrado");
    }

    Experience newExperience = this.experienceFactory.createExperience(data, developer.get());

    this.experienceRepository.save(newExperience);

    return  newExperience;
  }

}
