package com.br.sopermutaapi.exception.responseValidate;

import static org.springframework.util.ObjectUtils.isEmpty;

public class ValidateResponse {
    public void existId(Integer id){
        if(isEmpty(id)){
            throw new BadRequestException("Não foi informado o ID");
        }
    }
}
