package com.myportfolio.skill.controller;

import com.myportfolio.skill.dtos.SkillDTO;
import com.myportfolio.skill.models.Skill;
import com.myportfolio.skill.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("skills")

public class SkillController {

  @Autowired
  private SkillService skillService;

  @GetMapping()
  public List<Skill>listAllSkills() {
    return this.skillService.listAllSkills();
  }

  @PostMapping
  public ResponseEntity<Skill> createSkill(@RequestBody SkillDTO data) {
    return new ResponseEntity<>(this.skillService.createSkill(data), HttpStatus.CREATED);
  }

  @PostMapping("/developer/{developerId}/skill")
  public ResponseEntity<Skill> addSkill(@PathVariable(value = "developerId") Long developerId, @RequestBody SkillDTO data) {

    return new ResponseEntity<>(this.skillService.addSkillInDeveloper(developerId, data), HttpStatus.CREATED);
  }
}
