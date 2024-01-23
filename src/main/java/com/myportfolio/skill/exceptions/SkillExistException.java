package com.myportfolio.skill.exceptions;

import lombok.Getter;

import java.util.Map;

@Getter
public class SkillExistException extends RuntimeException{

  public SkillExistException(String message) {
    super(message);
  }
}
