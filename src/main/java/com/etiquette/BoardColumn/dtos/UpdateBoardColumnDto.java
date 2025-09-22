package com.etiquette.BoardColumn.dtos;

public class UpdateBoardColumnDto extends AddBoardColumnFormDto {
    
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
