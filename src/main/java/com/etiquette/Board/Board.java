package com.etiquette.Board;

import java.util.Date;
import java.util.List;

import com.etiquette.BoardColumn.BoardColumn;
import com.etiquette.Invitation.Invitation;
import com.etiquette.Participation.Participation;
import com.etiquette.Task.Task;
import com.etiquette.User.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false, updatable = false)
    private Date date_created;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userOwner_id")
    private User userOwner;

    @OneToMany(mappedBy = "board")
    private List<Participation> participations;

    @OneToMany(mappedBy = "board")
    private List<BoardColumn> boardcolumns;

    @OneToMany(mappedBy = "board")
    private List<Task> tasks;

    @OneToMany(mappedBy = "board")
    private List<Invitation> invitations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(User userOwner) {
        this.userOwner = userOwner;
    }

    @PrePersist
    void setDate() {
        this.date_created = new Date();
    }
    
}
