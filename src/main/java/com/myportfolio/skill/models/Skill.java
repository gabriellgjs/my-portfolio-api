package com.myportfolio.skill.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myportfolio.developer.models.Developer;
import com.myportfolio.experience.models.Experience;
import com.myportfolio.projects.models.Project;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "skills")
@Table(name = "skills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Skill {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique=true)
  private String name;

  @ManyToMany(mappedBy = "skills")
  @JsonIgnore
  private Set<Developer> developers = new HashSet<>();

  @ManyToMany(mappedBy = "skills")
  @JsonIgnore
  private Set<Experience> experiences = new HashSet<>();

  @ManyToMany(mappedBy = "skills")
  @JsonIgnore
  private Set<Project> projects = new HashSet<>();
}
