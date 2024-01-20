package com.myportfolio.resume.factories;

import com.myportfolio.developer.models.Developer;
import com.myportfolio.education.models.Education;
import com.myportfolio.projects.models.Project;
import com.myportfolio.resume.models.DeveloperResume;
import com.myportfolio.resume.models.Resume;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResumeFactory {

  public Resume createResume(Developer developer, List<Education> educations, List<Project> projects) {
    Resume resume = new Resume();

    DeveloperResume developerResume = new DeveloperResume(developer);

    resume.setDeveloper(developerResume);
    resume.setEducations(educations);
    resume.setProjects(projects);

    return resume;
  }
}
