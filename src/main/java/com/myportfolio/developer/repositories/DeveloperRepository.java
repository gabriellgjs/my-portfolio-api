package com.myportfolio.developer.repositories;

import com.myportfolio.developer.models.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
