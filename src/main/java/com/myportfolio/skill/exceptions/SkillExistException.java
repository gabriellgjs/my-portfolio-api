package com.myportfolio.skill.exceptions;

import lombok.Getter;

@Getter
public class SkillExistException extends RuntimeException{

  public SkillExistException(String message) {
    super(message);
  }
}
