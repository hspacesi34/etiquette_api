package com.etiquette.Participation.dtos;

import com.etiquette.Board.dtos.AddBoardDto;
import com.etiquette.User.dtos.AddUserDto;

public class AddParticipationFormDto {
    
    private AddUserDto user;
    private AddBoardDto board;

    public AddUserDto getUser() {
        return user;
    }

    public void setUser(AddUserDto user) {
        this.user = user;
    }

    public AddBoardDto getBoard() {
        return board;
    }

    public void setBoard(AddBoardDto board) {
        this.board = board;
    }
}
