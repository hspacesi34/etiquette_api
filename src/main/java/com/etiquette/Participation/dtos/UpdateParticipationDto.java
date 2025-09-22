package com.etiquette.Participation.dtos;

public class UpdateParticipationDto extends AddParticipationFormDto {
    
    private Integer id;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
