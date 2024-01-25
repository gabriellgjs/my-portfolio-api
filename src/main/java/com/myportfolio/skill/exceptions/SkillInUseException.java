package com.myportfolio.skill.exceptions;

import lombok.Getter;

@Getter
public class SkillInUseException extends RuntimeException{
  public SkillInUseException(String message) {
    super(message);
  }
}
