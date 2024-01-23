package com.myportfolio.skill.repositories;

import com.myportfolio.skill.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
  Optional<Skill> findByName(String name);
  List<Skill> findSkillsByDevelopersId(Long id);
}
