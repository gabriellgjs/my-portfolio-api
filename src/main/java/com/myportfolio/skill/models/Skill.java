package com.myportfolio.skill.models;


import com.myportfolio.developer.models.Developer;
import jakarta.persistence.*;
import lombok.*;

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

  private String name;

  @ManyToMany(mappedBy = "skills")
  private Set<Developer> developers;
}
