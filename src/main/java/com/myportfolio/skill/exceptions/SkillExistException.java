package com.myportfolio.skill.exceptions;

import lombok.Getter;

import java.util.Map;

@Getter
public class SkillExistException extends RuntimeException{
  private Map<String, String> errors;

  public SkillExistException(String message, Map<String, String> errors) {
    super(message);
    this.errors = errors;
  }
}
