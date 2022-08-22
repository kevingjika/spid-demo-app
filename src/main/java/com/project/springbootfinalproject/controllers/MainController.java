package com.project.springbootfinalproject.controllers;

import com.project.springbootfinalproject.entities.Spid;
import com.project.springbootfinalproject.services.SpidService;
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
    SpidService spidService;

    MainController(UsersService usersService){
        this.usersService = usersService;
    }

    private static final Logger log =   LoggerFactory.getLogger(MainController.class);

    @PostMapping("/create/user")
    public ResponseEntity<Users> createUser(
            @RequestBody Users users
    ) throws Exception {
        log.info(users.getName());
        Users savedUser = usersService.createUser(users);
        return new ResponseEntity(savedUser, HttpStatus.OK);
    }

    @PutMapping("/edit/user")
    public ResponseEntity<Users> editUser(
            @RequestBody Users users,
            @RequestParam long id
    ) throws Exception {
        users.setId(id);
        Users updatedUser = usersService.createUser(users);
        return new ResponseEntity(updatedUser, HttpStatus.OK);
    }

    @PostMapping("/create/spid")
    public ResponseEntity<Spid> createSpid (
            @RequestBody Spid spid
    ) throws Exception {
        log.info(spid.getStatus());
        log.info(spid.getType());
        Spid savedSpid = spidService.createSpid(spid);
        return new ResponseEntity(savedSpid, HttpStatus.OK);
    }

    @PutMapping("/edit/spid")
    public ResponseEntity<Spid> editSpid (
            @RequestBody Spid spid,
            @RequestParam long id
    ) throws Exception {
        spid.setId(id);
        Spid updatedSpid = spidService.createSpid(spid);
        return new ResponseEntity(updatedSpid, HttpStatus.OK);
    }



}