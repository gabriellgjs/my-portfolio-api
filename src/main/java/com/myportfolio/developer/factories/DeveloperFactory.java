package com.myportfolio.developer.factories;

import com.myportfolio.developer.dtos.DeveloperDTO;
import com.myportfolio.developer.models.Developer;
import com.myportfolio.user.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DeveloperFactory {

  public Developer getDeveloper(DeveloperDTO data, User user) {
    Developer newDeveloper = new Developer();

    newDeveloper.setName(data.name());
    newDeveloper.setEmail(data.email());
    newDeveloper.setGithubURL(data.githubURL());
    newDeveloper.setLinkedinURL(data.linkedinURL());
    newDeveloper.setAboutUs(data.aboutUs());
    newDeveloper.setWhatsappPhone(data.whatsappPhone());
    newDeveloper.setUser(user);

    return newDeveloper;
  }
}
