package com.myportfolio.skill.services;

import com.myportfolio.developer.exceptions.NotFoundDeveloperException;
import com.myportfolio.developer.models.Developer;
import com.myportfolio.developer.repositories.DeveloperRepository;
import com.myportfolio.skill.dtos.SkillDTO;
import com.myportfolio.skill.exceptions.NotFoundSkillException;
import com.myportfolio.skill.exceptions.SkillExistExceptionException;
import com.myportfolio.skill.exceptions.SkillInUseException;
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

  public Skill createSkill(SkillDTO skillRequest) {
    Optional<Skill> skillExist = this.skillRepository.findByName(skillRequest.name());

    if(skillExist.isPresent()) {
      throw new SkillExistExceptionException("Essa skill já existe!");
    }

    Skill newSKill =  skillFactory.createSkill(skillRequest);

    this.skillRepository.save(newSKill);

    return newSKill;
  }

  public List<Skill> listAllSkills() {
    return this.skillRepository.findAll();
  }

  public Skill updateSkill(Long skillId, SkillDTO skillRequest) {
    Skill updateSKill =  skillFactory.updateSKill(skillId, skillRequest);

    this.skillRepository.save(updateSKill);

    return updateSKill;
  }

  public void deleteSkill(Long skillId) {
    List<Developer> developersUsingSkill = this.developerRepository.findDevelopersBySkillsId(skillId);

    if(!developersUsingSkill.isEmpty()) {
      throw new SkillInUseException("Skill está sendo usada");
    }

    this.skillRepository.deleteById(skillId);
  }

  public List<Skill> listSkillByDeveloperId(Long developerId) {
    return this.skillRepository.findSkillsByDevelopersId(developerId);
  }

  public Optional<Skill> linkSkillInDeveloper(Long developerId, Long skillId) {
     return Optional.ofNullable(this.developerRepository.findById(developerId).map(developer -> {
       Skill skillExist = this.skillRepository.findById(skillId)
       .orElseThrow(() -> new NotFoundSkillException("Skill não encontrada"));

       developer.addSkill(skillExist);
       this.developerRepository.save(developer);

       return skillExist;
     }).orElseThrow(() -> new NotFoundDeveloperException("Desenvolvedor não encontrado")));
    }

  public void unlinkSkillInDeveloper(Long developerId, Long skillId) {
    this.developerRepository.findById(developerId).map(developer -> {
      Skill skillExist = this.skillRepository.findById(skillId)
      .orElseThrow(() -> new NotFoundSkillException("Skill não encontrada"));

      developer.removeSkill(skillExist.getId());
      this.developerRepository.save(developer);

      return null;
    }).orElseThrow(() -> new NotFoundDeveloperException("Desenvolvedor não encontrado"));
  }
}
