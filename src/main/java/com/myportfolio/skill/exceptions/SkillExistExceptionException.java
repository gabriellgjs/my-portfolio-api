package com.myportfolio.skill.exceptions;

import lombok.Getter;

@Getter
public class SkillExistExceptionException extends RuntimeException{
  public SkillExistExceptionException(String message) {
    super(message);
  }
}
