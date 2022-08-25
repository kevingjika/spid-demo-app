package com.project.springbootfinalproject.controllers;

import com.project.springbootfinalproject.entities.Spid;
import com.project.springbootfinalproject.entities.Spid.Status;
import com.project.springbootfinalproject.services.SpidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.springbootfinalproject.entities.Users;
import com.project.springbootfinalproject.services.UsersService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    UsersService usersService;
    @Autowired
    SpidService spidService;

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

   @GetMapping("/get/users")
    public ResponseEntity<Users> getAllUsers() {
        List<Users> listOfUsers = usersService.findAll();
        return new ResponseEntity(listOfUsers, HttpStatus.OK);
    }

    @GetMapping("/get/user")
    public ResponseEntity<Users> getUserById(@RequestParam long id){
        Optional<Users> oneUser = usersService.findById(id);
        return new ResponseEntity(oneUser, HttpStatus.OK);
    }


    @PostMapping("/create/user")
    public ResponseEntity<Users> createUser(@RequestBody Users users) throws Exception {
        log.info(users.getName());
        users.setCreatedAt(LocalDateTime.now());
        Users savedUser = usersService.createUser(users);
        return new ResponseEntity(savedUser, HttpStatus.OK);
    }

    @PutMapping("/edit/user")
    public ResponseEntity<Users> editUser(@RequestBody Users users, @RequestParam long id) throws Exception {
        users.setId(id);
        Users updatedUser = usersService.createUser(users);
        return new ResponseEntity(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/user")
    public ResponseEntity<Users> deleteUser(
            @RequestParam(name = "id") long id
    ) throws Exception {
        usersService.deleteUser(id);
        return new ResponseEntity("User-i u fshi me sukses.", HttpStatus.OK);
    }

    @GetMapping("/get/spids")
    public ResponseEntity<Spid> getAllSpids() {
        List<Spid> listOfSpids = spidService.findAll();
        return new ResponseEntity(listOfSpids, HttpStatus.OK);
    }

    @GetMapping("/get/spid")
    public ResponseEntity<Spid> getSpid(@RequestParam long id) throws Exception{
        Spid oneSpid = spidService.findSpidById(id);
        return new ResponseEntity(oneSpid, HttpStatus.OK);
    }



    @PostMapping("/create/spid")
    public ResponseEntity<Spid> createSpid(@RequestBody Spid spid) throws Exception {
        spid.setCreatedAt(LocalDateTime.now());
        Spid savedSpid = spidService.createSpid(spid);
        return new ResponseEntity(savedSpid, HttpStatus.OK);
    }

    @PutMapping("/edit/spid")
    public ResponseEntity<Spid> editSpid(@RequestBody Spid spid, @RequestParam long id) throws Exception {
        spid.setId(id);
        Spid updatedSpid = spidService.editSpid(spid);
        return new ResponseEntity(updatedSpid, HttpStatus.OK);
    }

    @DeleteMapping("/delete/spid")
    public ResponseEntity<Spid> deleteSpid(@RequestParam(name = "id") long id) throws Exception {
        spidService.deleteSpid(id);
        return new ResponseEntity("Spid-i u fshi me sukses.", HttpStatus.OK);
    }

    @PutMapping("/change/spid/status")
    public ResponseEntity<Spid> changeSpidStatus(@RequestParam long id) throws Exception {
        Spid updatedSpidStatus = spidService.changeSpidStatus(id);
        return new ResponseEntity(updatedSpidStatus, HttpStatus.OK);
    }

    @GetMapping ("/search/spid")
    public ResponseEntity<Spid> searchSpid(@RequestParam("name") String name) throws Exception {
        List<Spid> searchedSpid = spidService.searchSpid(name);
        return new ResponseEntity(searchedSpid, HttpStatus.OK);
    }



}