package com.etiquette.User;

import java.util.Date;
import java.util.List;

import com.etiquette.Encryption.CryptoConverter;
import com.etiquette.Invitation.Invitation;
import com.etiquette.Participation.Participation;
import com.etiquette.Role.Role;
import com.etiquette.Task.Task;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Users")
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false)
  private String firstname;

  @Column(nullable = false)
  private String lastname;

  @Column(unique = true, nullable = false)
  @Convert(converter = CryptoConverter.class)
  private String email;

  @Column(nullable = false)
  @Convert(converter = CryptoConverter.class)
  private String password;
  
  @Column(nullable = false, updatable = false)
  private Date date_created;

  @ManyToOne(optional = false)
  @JoinColumn(name = "role_id")
  private Role role;

  @OneToMany(mappedBy = "user")
  private List<Participation> userParticipations;

  @OneToMany(mappedBy = "userSender")
  private List<Invitation> userSenderInvitations;

  @OneToMany(mappedBy = "userReciever")
  private List<Invitation> userRecieverInvitations;

  @OneToMany(mappedBy = "user")
  private List<Task> tasks;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  

  @PrePersist
    void setDate() {
        this.date_created = new Date();
    }
}