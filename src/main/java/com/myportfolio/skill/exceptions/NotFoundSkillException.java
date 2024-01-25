package com.myportfolio.skill.exceptions;

import lombok.Getter;

@Getter
public class NotFoundSkillException extends  RuntimeException {
  public NotFoundSkillException(String message) {
    super(message);
  }
}
