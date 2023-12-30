package com.myportfolio.developer.services;

import com.myportfolio.developer.dtos.DeveloperDTO;
import com.myportfolio.developer.factories.DeveloperFactory;
import com.myportfolio.developer.models.Developer;
import com.myportfolio.developer.repositories.DeveloperRepository;
import com.myportfolio.user.models.User;
import com.myportfolio.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService {

  @Autowired
  private DeveloperRepository developerRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private DeveloperFactory developerFactory;


  public Developer createDeveloper(DeveloperDTO data) throws Exception {
    Optional<User> user = this.userRepository.findById(data.userId());

    if(user.isEmpty()){
      throw new Exception("Usuário não encontrado");
    }

    Developer newDeveloper = this.developerFactory.getDeveloper(data, user.get());


    this.developerRepository.save(newDeveloper);

    return newDeveloper;
  }

  public List<Developer> getAllDevelopers() {
    return this.developerRepository.findAll();
  }
}
