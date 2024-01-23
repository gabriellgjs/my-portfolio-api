package com.myportfolio.skill.controller;

import com.myportfolio.infra.ResponseException;
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

  @PostMapping
  public ResponseEntity<Skill> createSkill(@RequestBody @Valid SkillDTO data) {
    return new ResponseEntity<>(this.skillService.createSkill(data), HttpStatus.CREATED);
  }

  @PostMapping("/developer/{developerId}/skill")
  public ResponseEntity<Skill> addSkill(@PathVariable(value = "developerId") Long developerId, @RequestBody SkillDTO data) {

    return new ResponseEntity<>(this.skillService.addSkillInDeveloper(developerId, data), HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ResponseException> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });

    ResponseException threatResponse = new ResponseException(HttpStatus.BAD_REQUEST, "Erros de validações", errors);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
  }
}
