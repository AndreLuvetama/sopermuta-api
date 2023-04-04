package com.br.sopermutaapi.entities;


import com.br.sopermutaapi.entities.enums.Status;
import com.br.sopermutaapi.entities.enums.UserType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Entity
@Table(name = "USERS")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @NotBlank(message="The user name is required")
    @Column(name = "USERNAME")
    private String name;
        @Column(name = "USEREMAIL")
    //@NotBlank(message = "{email.not.blank}")
    //@Email(message = "{email.not.valid}")
    private String email;
    @NotBlank(message="The user password is required")
    @Column(name = "USERPASSWORD")
    private String password;
    @Column(name="INCLUDEDATE")
    private LocalDateTime includeDate;
    @Column(name = "BIRTHDATE")
    private Date dataNascimento;
    //@Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$", message = "the user phone is illegal.")
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "CITY")
    private String cidade;
    @Column(name = "US")
    private String estado;
    @Column(name = "USERTYPE")
    private UserType userType; //default 1
    @Column(name = "USERSTATUS")
    private Status userStatus;

}
