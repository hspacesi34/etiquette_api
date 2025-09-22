package com.etiquette.Participation.dtos;

import com.etiquette.Board.dtos.ReadBoardDto;
import com.etiquette.User.dtos.ReadUserDto;

public class ReadParticipationDto {
    
    private Integer id;
    private ReadUserDto user;
    private ReadBoardDto board;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ReadUserDto getUser() {
        return user;
    }

    public void setUser(ReadUserDto user) {
        this.user = user;
    }

    public ReadBoardDto getBoard() {
        return board;
    }

    public void setBoard(ReadBoardDto board) {
        this.board = board;
    }
}
