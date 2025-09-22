package com.etiquette.Invitation;

import com.etiquette.Board.Board;
import com.etiquette.User.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_sender_id")
    private User userSender;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_reciever_id")
    private User userReciever;

    @ManyToOne(optional = false)
    @JoinColumn(name = "board_id")
    private Board board;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public User getUserSender() {
        return userSender;
    }

    public void setUserSender(User userSender) {
        this.userSender = userSender;
    }

    public User getUserReciever() {
        return userReciever;
    }

    public void setUserReciever(User userReciever) {
        this.userReciever = userReciever;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    } 
    
}
