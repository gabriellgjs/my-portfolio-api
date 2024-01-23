package com.myportfolio.skill.controller;

import com.myportfolio.infra.ResponseException;
import com.myportfolio.skill.exceptions.NotFoundSkill;
import com.myportfolio.skill.exceptions.SkillExistException;
import com.myportfolio.skill.exceptions.SkillInUse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SkillExceptionController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(SkillExistException.class)
  private ResponseEntity<ResponseException> onSkillExistException(SkillExistException exception) {
    ResponseException threatResponse = new ResponseException(HttpStatus.BAD_REQUEST, exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
  }

  @ExceptionHandler(SkillInUse.class)
  private ResponseEntity<ResponseException> onSkillInUse(SkillInUse exception) {
    ResponseException threatResponse = new ResponseException(HttpStatus.BAD_REQUEST, exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
  }

  @ExceptionHandler(NotFoundSkill.class)
  private ResponseEntity<ResponseException> onNotFoundSkill(NotFoundSkill exception) {
    ResponseException threatResponse = new ResponseException(HttpStatus.BAD_REQUEST, exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
  }
}