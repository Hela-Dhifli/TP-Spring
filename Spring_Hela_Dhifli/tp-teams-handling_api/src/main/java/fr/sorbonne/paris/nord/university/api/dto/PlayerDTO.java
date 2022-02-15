package fr.sorbonne.paris.nord.university.api.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
@Data
public class PlayerDTO {
    private long id;
    @NotEmpty
    private String name;
    private String number;
    private String position;

}

