package com.myportfolio.projects.models;

import com.myportfolio.developer.models.Developer;
import jakarta.persistence.*;
import lombok.*;

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
  private Developer developer;
}
