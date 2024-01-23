package com.myportfolio.skill.exceptions;

import lombok.Getter;

@Getter
public class NotFoundSkill extends  RuntimeException {
  public NotFoundSkill(String message) {
    super(message);
  }
}
