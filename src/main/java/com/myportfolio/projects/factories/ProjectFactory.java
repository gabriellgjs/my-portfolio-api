package com.myportfolio.projects.factories;

import com.myportfolio.developer.models.Developer;
import com.myportfolio.projects.dtos.ProjectDTO;
import com.myportfolio.projects.models.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectFactory {

  public Project createProject(ProjectDTO data, Developer developer) {
    Project newProject = new Project();

    newProject.setTitle(data.title());
    newProject.setCaption(data.caption());
    newProject.setOwner(data.owner());
    newProject.setDescription(data.description());
    newProject.setUrl(data.url().orElse(""));
    newProject.setDeveloper(developer);

    return newProject;
  }
}
