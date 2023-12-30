package com.myportfolio.developer.models;

import com.myportfolio.user.models.User;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "developer")
@Table(name = "developer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Developer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;
  private String name;
  private String email;
  private String githubURL;
  private String linkedinURL;
  private String aboutUs;
  private String whatsappPhone;
  private String curriculum = "";

  @ManyToOne
  @JoinColumn(name="userId")
  private User user;
}
