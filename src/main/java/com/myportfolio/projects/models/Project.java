package com.myportfolio.projects.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myportfolio.developer.models.Developer;
import com.myportfolio.skill.models.Skill;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "projects")
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private String caption;

  private String owner;

  private String description;

  private String url = "";

  @ManyToOne
  @JoinColumn(name="developer_id")
  @JsonIgnore
  private Developer developer;

  @ManyToMany
  @JoinTable(name = "projects_skills",
  joinColumns = @JoinColumn(name ="project_id"),
  inverseJoinColumns = @JoinColumn(name = "skill_id")
  )
  private Set<Skill> skills = new HashSet<>();
}
