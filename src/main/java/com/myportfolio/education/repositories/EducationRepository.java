package com.myportfolio.education.repositories;

import com.myportfolio.education.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
  List<Education> findByDeveloperId(Long id);
}
