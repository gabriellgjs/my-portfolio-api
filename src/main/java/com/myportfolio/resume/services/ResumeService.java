package com.myportfolio.resume.services;

import com.myportfolio.developer.models.Developer;
import com.myportfolio.developer.repositories.DeveloperRepository;
import com.myportfolio.resume.factories.ResumeFactory;
import com.myportfolio.resume.model.DeveloperResume;
import com.myportfolio.resume.model.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

  @Autowired
  private DeveloperRepository developerRepository;

  @Autowired
  private ResumeFactory resumeFactory;

  public Resume resume(Long id) {
    Developer developer = this.developerRepository.findById(id).get();

    Resume newResume = this.resumeFactory.createResume(developer);

    return newResume;
  }
}
