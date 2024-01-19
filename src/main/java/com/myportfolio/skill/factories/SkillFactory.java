package com.myportfolio.skill.factories;

import com.myportfolio.skill.dtos.SkillDTO;
import com.myportfolio.skill.models.Skill;
import org.springframework.stereotype.Component;

@Component
public class SkillFactory {
  public Skill createSkill(SkillDTO data) {
    Skill newSkill = new Skill();

    newSkill.setName(data.name());

    return  newSkill;
  }
}
