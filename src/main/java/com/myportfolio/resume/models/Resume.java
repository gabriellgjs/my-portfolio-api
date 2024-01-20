package com.myportfolio.resume.models;

import com.myportfolio.education.models.Education;
import com.myportfolio.projects.models.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resume {

  private DeveloperResume developer;
  private List<Education> educations;
  private List<Project> projects;
}
