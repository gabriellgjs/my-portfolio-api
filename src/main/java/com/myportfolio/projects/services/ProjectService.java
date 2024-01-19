package com.myportfolio.projects.services;

import com.myportfolio.developer.models.Developer;
import com.myportfolio.developer.repositories.DeveloperRepository;
import com.myportfolio.projects.dtos.ProjectDTO;
import com.myportfolio.projects.factories.ProjectFactory;
import com.myportfolio.projects.models.Project;
import com.myportfolio.projects.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepository;

  @Autowired
  private ProjectFactory projectFactory;

  @Autowired
  private DeveloperRepository developerRepository;

  public Project createProject(ProjectDTO data) throws Exception {
    Optional<Developer> developer = this.developerRepository.findById(data.developerId());

    if(developer.isEmpty()){
      throw new Exception("Desenvolvedor não encontrado");
    }

    Project newProject = this.projectFactory.createProject(data, developer.get());

    this.projectRepository.save(newProject);

    return newProject;
  }

  public List<Project> listAllProjects() {
    return this.projectRepository.findAll();
  }
}
