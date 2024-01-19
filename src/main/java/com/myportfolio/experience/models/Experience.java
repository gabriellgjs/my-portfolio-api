package com.myportfolio.experience.models;

import com.myportfolio.developer.models.Developer;
import com.myportfolio.skill.models.Skill;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "experiences")
@Table(name = "experiences")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Experience {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private String caption;

  @Temporal(TemporalType.DATE)
  @Column(name="date_start")
  private Date dateStart;

  @Temporal(TemporalType.DATE)
  @Column(name="date_end")
  private Date dateEnd;

  @ManyToOne
  @JoinColumn(name="developer_id")
  private Developer developer;

  @ManyToMany
  @JoinTable(name = "experiences_skills",
  joinColumns = @JoinColumn(name ="experience_id"),
  inverseJoinColumns = @JoinColumn(name = "skill_id")
  )
  private Set<Skill> skills;
}
