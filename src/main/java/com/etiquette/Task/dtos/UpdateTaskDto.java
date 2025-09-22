package com.etiquette.Task.dtos;

public class UpdateTaskDto extends AddTaskFormDto {
    
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
