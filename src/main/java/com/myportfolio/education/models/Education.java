package com.myportfolio.education.models;

import com.myportfolio.developer.models.Developer;
import com.myportfolio.education.enums.SituationType;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "educations")
@Table(name = "educations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Education {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String course;

  private String institution;

  @Enumerated(EnumType.STRING)
  private SituationType situation;

  @ManyToOne
  @JoinColumn(name="developers_id")
  private Developer developer;
}
