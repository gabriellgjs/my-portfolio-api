package com.myportfolio.resume.model;

import com.myportfolio.developer.models.Developer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

 public DeveloperResume(Developer developer) {
   this.id = developer.getId();
   this.name = developer.getName();
   this.email = developer.getEmail();
   this.githubURL = developer.getGithubURL();
   this.linkedinURL = developer.getLinkedinURL();
   this.aboutUs = developer.getAboutUs();
   this.whatsappPhone = developer.getWhatsappPhone();
   this.curriculum = developer.getCurriculum();
 }
}
