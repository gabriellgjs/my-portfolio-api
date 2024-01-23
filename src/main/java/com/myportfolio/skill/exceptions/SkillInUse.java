package com.myportfolio.skill.exceptions;

import lombok.Getter;

import java.util.Map;

@Getter
public class SkillInUse extends RuntimeException{

  public SkillInUse(String message) {
    super(message);
  }
}
