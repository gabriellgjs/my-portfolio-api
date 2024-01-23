package com.myportfolio.developer.repositories;

import com.myportfolio.developer.models.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
  List<Developer> findDevelopersBySkillsId(Long id);
}
