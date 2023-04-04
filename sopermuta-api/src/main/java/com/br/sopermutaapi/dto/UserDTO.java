package com.br.sopermutaapi.dto;

import com.br.sopermutaapi.entities.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Date includeDate;
    private UserType userType; //default 1
}
