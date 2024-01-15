package com.myportfolio.education.models;

import com.myportfolio.developer.models.Developer;
import com.myportfolio.education.enums.SituationType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
  @JoinColumn(name="developer_id")
  private Developer developer;

  @Temporal(TemporalType.DATE)
  @Column(name="date_start")
  private Date dateStart;

  @Temporal(TemporalType.DATE)
  @Column(name="date_end")
  private Date dateEnd;
}
