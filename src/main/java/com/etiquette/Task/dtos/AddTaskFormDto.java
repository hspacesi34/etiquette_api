package com.etiquette.Task.dtos;

import com.etiquette.Board.dtos.AddBoardDto;
import com.etiquette.BoardColumn.dtos.AddBoardColumn;
import com.etiquette.User.dtos.AddUserDto;

public class AddTaskFormDto {
    private String name;
    private String description;
    private String priority;
    private String status;
    private AddBoardDto board;
    private AddBoardColumn boardColumn;
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

    public AddBoardColumn getBoardColumn() {
        return boardColumn;
    }

    public void setBoardColumn(AddBoardColumn boardColumn) {
        this.boardColumn = boardColumn;
    }

    public AddUserDto getUser() {
        return user;
    }

    public void setUser(AddUserDto user) {
        this.user = user;
    }
}
