package com.myportfolio.skill.controller;

import com.myportfolio.developer.exceptions.NotFoundDeveloperException;
import com.myportfolio.infra.ResponseException;
import com.myportfolio.skill.exceptions.NotFoundSkillException;
import com.myportfolio.skill.exceptions.SkillExistExceptionException;
import com.myportfolio.skill.exceptions.SkillInUseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SkillExceptionController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(SkillExistExceptionException.class)
  private ResponseEntity<ResponseException> onSkillExistException(SkillExistExceptionException exception) {
    ResponseException threatResponse = new ResponseException(HttpStatus.BAD_REQUEST, exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
  }

  @ExceptionHandler(SkillInUseException.class)
  private ResponseEntity<ResponseException> onSkillInUse(SkillInUseException exception) {
    ResponseException threatResponse = new ResponseException(HttpStatus.BAD_REQUEST, exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
  }

  @ExceptionHandler(NotFoundSkillException.class)
  private ResponseEntity<ResponseException> onNotFoundSkill(NotFoundSkillException exception) {
    ResponseException threatResponse = new ResponseException(HttpStatus.BAD_REQUEST, exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
  }

  @ExceptionHandler(NotFoundDeveloperException.class)
  private ResponseEntity<ResponseException> onNotFoundDeveloper(NotFoundDeveloperException exception) {
    ResponseException threatResponse = new ResponseException(HttpStatus.BAD_REQUEST, exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
  }
}
