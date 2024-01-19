package com.myportfolio.skill.services;

import com.myportfolio.skill.dtos.SkillDTO;
import com.myportfolio.skill.factories.SkillFactory;
import com.myportfolio.skill.models.Skill;
import com.myportfolio.skill.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

  @Autowired
  private SkillRepository skillRepository;

  @Autowired
  private SkillFactory skillFactory;
  public Skill createSkill(SkillDTO data) {

    Skill newSKill =  skillFactory.createSkill(data);

    this.skillRepository.save(newSKill);

    return newSKill;
  }

  public List<Skill> listAllSkills() {
    return this.skillRepository.findAll();
  }
}
