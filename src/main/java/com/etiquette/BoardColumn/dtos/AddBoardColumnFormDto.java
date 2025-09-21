package com.etiquette.BoardColumn.dtos;

public class AddBoardColumnFormDto {
    
    private String name;
    private AddBoardColumnDto board;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddBoardColumnDto getBoard() {
        return board;
    }

    public void setBoard(AddBoardColumnDto board) {
        this.board = board;
    }
}
