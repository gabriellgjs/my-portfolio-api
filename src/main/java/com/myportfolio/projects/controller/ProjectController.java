package com.myportfolio.projects.controller;

import com.myportfolio.projects.dtos.ProjectDTO;
import com.myportfolio.projects.models.Project;
import com.myportfolio.projects.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
public class ProjectController {
  @Autowired
  private ProjectService projectService;
  @GetMapping
  public ResponseEntity<List<Project>>listALlProjects() {
    return new ResponseEntity<>(this.projectService.listAllProjects(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Project> createProject(@RequestBody ProjectDTO data) throws Exception {
    return new ResponseEntity<>(this.projectService.createProject(data), HttpStatus.CREATED);
  }
}
