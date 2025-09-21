package com.etiquette.Task.dtos;

import java.util.Date;

public class ReadTaskDto extends AddTaskFormDto {
    private Integer id;
    private Date date_created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return date_created;
    }
}
