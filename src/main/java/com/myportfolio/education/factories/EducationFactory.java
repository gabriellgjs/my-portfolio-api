package com.myportfolio.education.factories;

import com.myportfolio.developer.models.Developer;
import com.myportfolio.education.dtos.EducationDTO;
import com.myportfolio.education.models.Education;
import org.springframework.stereotype.Component;

@Component
public class EducationFactory {
  public Education getDeveloper(EducationDTO data, Developer developer) {
    Education newEducation = new Education();

    newEducation.setCourse(data.course());
    newEducation.setInstitution(data.institution());
    newEducation.setSituation(data.situation());
    newEducation.setDeveloper(developer);

    return newEducation;
  }
}
