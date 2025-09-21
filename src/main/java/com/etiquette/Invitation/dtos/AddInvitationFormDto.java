package com.etiquette.Invitation.dtos;

import com.etiquette.Board.dtos.AddBoardDto;
import com.etiquette.User.dtos.AddUserDto;

public class AddInvitationFormDto {
    
    private String status;
    private AddUserDto userSender;
    private AddUserDto userReciever;
    private AddBoardDto board;

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public AddUserDto getUserSender() {
        return userSender;
    }

    public void setUserSender(AddUserDto userSender) {
        this.userSender = userSender;
    }

    public AddUserDto getUserReciever() {
        return userReciever;
    }

    public void setUserReciever(AddUserDto userReciever) {
        this.userReciever = userReciever;
    }

    public AddBoardDto getBoard() {
        return board;
    }

    public void setBoard(AddBoardDto board) {
        this.board = board;
    } 
}
