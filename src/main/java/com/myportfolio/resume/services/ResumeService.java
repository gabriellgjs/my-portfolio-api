package com.myportfolio.resume.services;

import com.myportfolio.developer.models.Developer;
import com.myportfolio.developer.repositories.DeveloperRepository;
import com.myportfolio.education.models.Education;
import com.myportfolio.education.repositories.EducationRepository;
import com.myportfolio.resume.factories.ResumeFactory;
import com.myportfolio.resume.models.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeService {

  @Autowired
  private DeveloperRepository developerRepository;

  @Autowired
  private EducationRepository educationRepository;


  @Autowired
  private ResumeFactory resumeFactory;

  public Resume resume(Long id) {
    Developer developer = this.developerRepository.findById(id).get();
    List<Education> educations = this.educationRepository.findByDeveloperId(id);

    Resume newResume = this.resumeFactory.createResume(developer, educations);

    return newResume;
  }
}
