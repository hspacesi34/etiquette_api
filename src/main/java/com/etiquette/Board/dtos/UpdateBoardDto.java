package com.etiquette.Board.dtos;

public class UpdateBoardDto extends AddBoardFormDto {
    
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
