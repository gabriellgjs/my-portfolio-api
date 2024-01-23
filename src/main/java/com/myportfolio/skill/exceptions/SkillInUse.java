package com.myportfolio.skill.exceptions;

import lombok.Getter;

@Getter
public class SkillInUse extends RuntimeException{

  public SkillInUse(String message) {
    super(message);
  }
}
