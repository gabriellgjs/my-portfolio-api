package com.myportfolio.skill.services;

import com.myportfolio.developer.repositories.DeveloperRepository;
import com.myportfolio.skill.dtos.SkillDTO;
import com.myportfolio.skill.factories.SkillFactory;
import com.myportfolio.skill.models.Skill;
import com.myportfolio.skill.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    List<Skill> skillsList = new ArrayList<>();
    this.skillRepository.findAll().forEach(skillsList::add);


    return skillsList;
  }

  public Skill addSkillInDeveloper(Long developerId, SkillDTO skillRequest) {
     Skill skill = this.developerRepository.findById(developerId).map(developer -> {
       if(skillRequest.id().isPresent()) {
         Long skillId = skillRequest.id().get();
         Skill skillExist = this.skillRepository.findById(skillId)
         .orElseThrow(() -> new RuntimeException("Not found Skill with id = " + skillId));
         developer.addSkill(skillExist);
         this.developerRepository.save(developer);
         return skillExist;
       }


       Skill newSKill =  skillFactory.createSkill(skillRequest);

       developer.addSkill(newSKill);
        this.skillRepository.save(newSKill);
       return newSKill;


    }).orElseThrow(() -> new RuntimeException("Not found Developer with id = " + developerId));

     return skill;
  }
}
