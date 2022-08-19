package com.project.springbootfinalproject.controllers;

import com.project.springbootfinalproject.entities.Spid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.springbootfinalproject.entities.Users;
import com.project.springbootfinalproject.services.UsersService;

@RestController
@RequestMapping(value = "/user")
public class MainController {

    UsersService usersService;

    MainController(UsersService usersService){
        this.usersService = usersService;
    }

    private static final Logger log =   LoggerFactory.getLogger(MainController.class);

    @PostMapping("/create/user")
    public ResponseEntity<Users> createUser(
            @RequestBody Users users
    ) throws Exception {
        log.info(users.getName());
        usersService.createUser(users);
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @PutMapping("/edit/user")
    public ResponseEntity<Users> editUser(
            @RequestBody Users users,
            @RequestParam long id
    ) throws Exception {
        users.setId(id);
        return new ResponseEntity(usersService.createUser(users), HttpStatus.OK);
    }



}