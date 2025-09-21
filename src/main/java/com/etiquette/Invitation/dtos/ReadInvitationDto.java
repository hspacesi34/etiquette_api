package com.etiquette.Invitation.dtos;

public class ReadInvitationDto extends AddInvitationFormDto {
    
    private Integer id;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
