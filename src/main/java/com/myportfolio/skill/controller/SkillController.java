package com.myportfolio.skill.controller;

import com.myportfolio.infra.ResponseValidationException;
import com.myportfolio.skill.dtos.LinkSkillWithDeveloperDTO;
import com.myportfolio.skill.dtos.SkillDTO;
import com.myportfolio.skill.models.Skill;
import com.myportfolio.skill.services.SkillService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("skills")

public class SkillController {

  @Autowired
  private SkillService skillService;

  @GetMapping
  public List<Skill>listAllSkills() {
    return this.skillService.listAllSkills();
  }

  @GetMapping("/developer/{developerId}")
  public ResponseEntity<List<Skill>> listSKillByDeveloper(@PathVariable(value = "developerId") Long developerId){
    return new ResponseEntity<>(this.skillService.listSkillByDeveloperId(developerId), HttpStatus.OK);
  }

  @PutMapping("/{skillId}")
  public ResponseEntity<Skill> updateSkill (
    @PathVariable(value = "skillId") Long skillId,
    @RequestBody @Valid SkillDTO data) {
    return new ResponseEntity<>(this.skillService.updateSkill(skillId, data), HttpStatus.OK);
  }

  @DeleteMapping("/{skillId}")
  public ResponseEntity deleteSkill (
  @PathVariable(value = "skillId") Long skillId) {
    this.skillService.deleteSkill(skillId);
    return ResponseEntity.noContent().build();
  }

  @PostMapping
  public ResponseEntity<Skill> createSkill(@RequestBody @Valid SkillDTO data) {
    return new ResponseEntity<>(this.skillService.createSkill(data), HttpStatus.CREATED);
  }

  @PostMapping("/link/developer/{developerId}")
  public ResponseEntity<Optional<Skill>> linkSKillWithDeveloper(@PathVariable(value = "developerId") Long developerId, @RequestBody LinkSkillWithDeveloperDTO data) {
    return new ResponseEntity<>(this.skillService.addSkillInDeveloper(developerId, data), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ResponseValidationException> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });

    ResponseValidationException threatResponse = new ResponseValidationException(HttpStatus.BAD_REQUEST, "Erros de validações", errors);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
  }
}
