package com.myportfolio.infra;

import com.myportfolio.skill.exceptions.SkillExistException;
import com.myportfolio.skill.exceptions.SkillInUse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

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
}
