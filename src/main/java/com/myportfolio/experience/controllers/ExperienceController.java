package com.myportfolio.experience.controllers;

import com.myportfolio.experience.dtos.ExperienceDTO;
import com.myportfolio.experience.models.Experience;
import com.myportfolio.experience.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("experiences")
public class ExperienceController {

  @Autowired
  private ExperienceService experienceService;

  @GetMapping
  public List<Experience> getAllExperiences() {
    return this.experienceService.getAllExperiences();
  }

  @PostMapping
  public Experience createExperience(@RequestBody ExperienceDTO data) throws Exception {
    return this.experienceService.createExperience(data);
  }
}
