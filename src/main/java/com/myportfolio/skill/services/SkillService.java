package com.myportfolio.skill.services;

import com.myportfolio.developer.models.Developer;
import com.myportfolio.developer.repositories.DeveloperRepository;
import com.myportfolio.skill.dtos.SkillDTO;
import com.myportfolio.skill.exceptions.SkillExistException;
import com.myportfolio.skill.exceptions.SkillInUse;
import com.myportfolio.skill.factories.SkillFactory;
import com.myportfolio.skill.models.Skill;
import com.myportfolio.skill.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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

  public Skill createSkill(SkillDTO skillRequest) {
    Optional<Skill> skillExist = this.skillRepository.findByName(skillRequest.name());

    if(skillExist.isPresent()) {
      HashMap<String, String> errors = new HashMap<>();

      errors.put("name", skillRequest.name());

      throw new SkillExistException("Essa skill já existe!");
    }

    Skill newSKill =  skillFactory.createSkill(skillRequest);

    this.skillRepository.save(newSKill);

    return newSKill;
  }

  public List<Skill> listAllSkills() {
    List<Skill> skillsList = new ArrayList<>();
    this.skillRepository.findAll().forEach(skillsList::add);

    return skillsList;
  }

  public Skill updateSkill(Long skillId, SkillDTO skillRequest) {
    Skill updateSKill =  skillFactory.updateSKill(skillId, skillRequest);

    this.skillRepository.save(updateSKill);
    return updateSKill;
  }
  public void deleteSkill(Long skillId) {
    List<Developer> developersUsingSkill = this.developerRepository.findDevelopersBySkillsId(skillId);

    if(developersUsingSkill.size() > 0) {
      throw new SkillInUse("Skill está sendo usada");
    }

    this.skillRepository.deleteById(skillId);
  }


  public List<Skill>listSkillByDeveloperId(Long developerId) {
    return this.skillRepository.findSkillsByDevelopersId(developerId);
  }

  public Skill addSkillInDeveloper(Long developerId, SkillDTO skillRequest) {
     return this.developerRepository.findById(developerId).map(developer -> {
       if(skillRequest.id().isPresent()) {
         Long skillId = skillRequest.id().get();
         Skill skillExist = this.skillRepository.findById(skillId)
          .orElseThrow(() -> new RuntimeException("Not found Skill with id = " + skillId));

         if(skillExist.getName().equalsIgnoreCase(skillRequest.name())) {
           throw new SkillExistException("Essa skill já existe!");
         }

         developer.addSkill(skillExist);
         this.developerRepository.save(developer);

         return skillExist;
       }


       Skill newSKill =  skillFactory.createSkill(skillRequest);

       developer.addSkill(newSKill);
        this.skillRepository.save(newSKill);
       return newSKill;


    }).orElseThrow(() -> new RuntimeException("Not found Developer with id = " + developerId));
  }
}
