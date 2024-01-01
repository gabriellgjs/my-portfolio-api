package com.myportfolio.education.controllers;

import com.myportfolio.education.dtos.EducationDTO;
import com.myportfolio.education.models.Education;
import com.myportfolio.education.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("educations")
public class EducationController {

  @Autowired
  private EducationService educationService;

  @GetMapping
  public List<Education> getAllEducations() {
    return this.educationService.getAllEducation();
  }

  @GetMapping("/{id}")
  public List<Education> getAllByDeveloperId(@PathVariable Long id) {
    return this.educationService.getEducationByDeveloperId(id);
  }

  @PostMapping
  public Education createEducation(@RequestBody EducationDTO data) throws Exception {
    return this.educationService.createEducation(data);
  }

}
