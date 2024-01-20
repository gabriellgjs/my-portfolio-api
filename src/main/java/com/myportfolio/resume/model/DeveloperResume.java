package com.myportfolio.resume.model;

import com.myportfolio.developer.models.Developer;
import com.myportfolio.skill.models.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperResume {
  private Long id;
  private String name;
  private String email;
  private String githubURL;
  private String linkedinURL;
  private String aboutUs;
  private String whatsappPhone;
  private  String curriculum = "";
  private Set<Skill> skills = new HashSet<>();


  public DeveloperResume(Developer developer) {
   this.id = developer.getId();
   this.name = developer.getName();
   this.email = developer.getEmail();
   this.githubURL = developer.getGithubURL();
   this.linkedinURL = developer.getLinkedinURL();
   this.aboutUs = developer.getAboutUs();
   this.whatsappPhone = developer.getWhatsappPhone();
   this.curriculum = developer.getCurriculum();
   this.skills = developer.getSkills();
 }
}
