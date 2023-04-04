package com.br.sopermutaapi.service;


import com.br.sopermutaapi.entities.Users;
import com.br.sopermutaapi.exception.SuccessResponse;
import com.br.sopermutaapi.exception.responseValidate.BadRequestException;
import com.br.sopermutaapi.exception.responseValidate.NotFoundException;
import com.br.sopermutaapi.repository.UserRepository;
import com.br.sopermutaapi.util.ValidationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ValidationData validationData;


    public List<Users> findAll(){
        List<Users> usersList = userRepository.findAll();
        return usersList;
    }

    public Users insertUser(Users userDTO){
        Users users = new Users();
        if (isEmpty(validationData.existEmail(userDTO.getEmail()))){
             users = userRepository.save(userDTO);
        }else{
            throw new BadRequestException("Email já cadastrado");
        }
            return  users;
    }
    public SuccessResponse deleteUser(Integer id) {
        findbyId(id);
        userRepository.deleteById(id);
        return SuccessResponse.createResponse("Usuário deletado com sucesso");
    }

    public Users update(Users request, Integer id) {
        Users user = new Users();
        findbyId(id);
        return user = userRepository.save(request);
    }

    public Users findByEmail(String email) {
        if(!validationData.emailValidator(email)){
            throw new BadRequestException("Email com o formato inválido");
        }
        return userRepository
                .findByEmail(email)
                .orElseThrow(()-> new NotFoundException("Email não encontrado"));

    }
    public Users findbyId(Integer id) {
        if(isEmpty(id)){
            throw new NotFoundException("Informe o ID");
        }
        return userRepository
                .findById(id)
                .orElseThrow(()-> new NotFoundException("Usuário não encontrado"));
    }

    /*private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static boolean emailValidator(String email)
    {
        if (email == null) {
            return false;
        }

        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }*/

}
