package com.myportfolio.resume.factories;

import com.myportfolio.developer.models.Developer;
import com.myportfolio.resume.model.DeveloperResume;
import com.myportfolio.resume.model.Resume;
import org.springframework.stereotype.Component;

@Component
public class ResumeFactory {

  public Resume createResume(Developer developer) {
    Resume resume = new Resume();

    DeveloperResume developerResume = new DeveloperResume(developer);

    resume.setDeveloper(developerResume);

    return resume;
  }
}
