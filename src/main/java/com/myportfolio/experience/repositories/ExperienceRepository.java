package com.myportfolio.experience.repositories;

import com.myportfolio.experience.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
  List<Experience> findByDeveloperId(Long id);

}
