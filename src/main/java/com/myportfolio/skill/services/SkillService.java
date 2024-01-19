package com.myportfolio.skill.services;

import com.myportfolio.developer.models.Developer;
import com.myportfolio.developer.repositories.DeveloperRepository;
import com.myportfolio.skill.dtos.SkillDTO;
import com.myportfolio.skill.factories.SkillFactory;
import com.myportfolio.skill.models.Skill;
import com.myportfolio.skill.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

  @Autowired
  private SkillRepository skillRepository;

  @Autowired
  private DeveloperRepository developerRepository;

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

  public Skill addSkillInDeveloper(Long developerId, SkillDTO skillRequest) {
    Developer developer2 =  this.developerRepository.findById(developerId).get();

     Skill skill = this.developerRepository.findById(developerId).map(developer -> {
       Optional<Long> skillId = skillRequest.id();

      // skill is existed
      if (skillId.isPresent()) {
        Skill skillExist = this.skillRepository.findById(skillId.get())
        .orElseThrow(() -> new RuntimeException("Not found Skill with id = " + skillId));
        developer.addSkill(skillExist);
        this.developerRepository.save(developer);
        return skillExist;
      }

      // add and create new Skill
      Skill newSkill = this.skillFactory.createSkill(skillRequest);

      developer.addSkill(newSkill);
       this.developerRepository.save(developer);
      return newSkill;
    }).orElseThrow(() -> new RuntimeException("Not found Developer with id = " + developerId));

     return skill;
  }
}
