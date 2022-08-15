package com.project.springbootfinalproject.services;

import com.project.springbootfinalproject.entities.Spid;
import com.project.springbootfinalproject.entities.Users;
import com.project.springbootfinalproject.exceptions.NoUsersFoundException;
import com.project.springbootfinalproject.repository.SpidRepository;
import com.project.springbootfinalproject.repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.springbootfinalproject.repository.SpidRepository;
import com.project.springbootfinalproject.entities.Spid;
import com.project.springbootfinalproject.entities.Status;
import com.project.springbootfinalproject.entities.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SpidService {


    SpidRepository spidRepository;

    SpidService(SpidRepository spidRepository){
        this.spidRepository = spidRepository;
    }

}
