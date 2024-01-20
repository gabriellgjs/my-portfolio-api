package com.myportfolio.skill.exceptions;

public class SkillExistException extends RuntimeException{
  public SkillExistException() {
    super("Essa skill já existe!");
  }

  public SkillExistException(String message) {
    super(message);
  }
}
