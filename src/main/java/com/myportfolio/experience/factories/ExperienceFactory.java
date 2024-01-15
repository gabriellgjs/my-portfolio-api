package com.myportfolio.experience.factories;

import com.myportfolio.developer.models.Developer;
import com.myportfolio.experience.dtos.ExperienceDTO;
import com.myportfolio.experience.models.Experience;
import org.springframework.stereotype.Component;

@Component
public class ExperienceFactory {

  public Experience createExperience(ExperienceDTO data, Developer developer) {
    Experience newExperience = new Experience();

    newExperience.setTitle(data.title());
    newExperience.setCaption(data.caption());
    newExperience.setDateStart(data.dateStart());
    newExperience.setDateEnd(data.dateEnd());
    newExperience.setDeveloper(developer);

    return  newExperience;
  }
}
