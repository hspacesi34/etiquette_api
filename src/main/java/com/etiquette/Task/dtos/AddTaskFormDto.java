package com.etiquette.Task.dtos;

import com.etiquette.Board.dtos.AddBoardDto;
import com.etiquette.BoardColumn.dtos.AddBoardColumnDto;
import com.etiquette.User.dtos.AddUserDto;

public class AddTaskFormDto {
    private String name;
    private String description;
    private String priority;
    private String status;
    private AddBoardDto board;
    private AddBoardColumnDto boardColumn;
    private AddUserDto user;

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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AddBoardDto getBoard() {
        return board;
    }

    public void setBoard(AddBoardDto board) {
        this.board = board;
    }

    public AddBoardColumnDto getBoardColumn() {
        return boardColumn;
    }

    public void setBoardColumn(AddBoardColumnDto boardColumn) {
        this.boardColumn = boardColumn;
    }

    public AddUserDto getUser() {
        return user;
    }

    public void setUser(AddUserDto user) {
        this.user = user;
    }
}
