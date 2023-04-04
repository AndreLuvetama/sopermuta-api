package com.br.sopermutaapi.controller;

import com.br.sopermutaapi.entities.Users;
import com.br.sopermutaapi.exception.SuccessResponse;
import com.br.sopermutaapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequiredArgsConstructor
@RequestMapping("/sopermutaimoveis")
public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    private List<Users> findAll(){
        List<Users> userList = userService.findAll();
        return userList;
    }

    @PostMapping("/insertUser")
    @ResponseStatus(HttpStatus.CREATED)
    private Users insertUser( @RequestBody @Valid Users userRequest){
        Users user = userService.insertUser(userRequest);
        return user;
    }
    /*@PostMapping
    public Users save(@RequestBody Users request){
        return userService.insertUser(request);
    }*/

    @DeleteMapping("/{id}")
    public SuccessResponse delete(@PathVariable("id") Integer id){
        return userService.deleteUser(id);
    }
    @PutMapping("/{id}")
    public Users update(@RequestBody Users request, @PathVariable Integer id){
      return userService.update(request, id);
    }

    @GetMapping("id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Users findId(@PathVariable Integer id){
        return userService.findbyId(id);
    }

    //@RequestMapping(value = "email/{email}", method = RequestMethod.GET)
    @GetMapping("email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Users findEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }



}
