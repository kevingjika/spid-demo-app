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


    static SpidRepository spidRepository;

    SpidService(SpidRepository spidRepository){
        this.spidRepository = spidRepository;
    }

    public static Spid createSpid(Spid spid) throws Exception {
        Optional<Spid> findIfSpidExists = spidRepository.findById(spid.getId());

        if(findIfSpidExists.isPresent()){
            throw new NoUsersFoundException("Spid-i ekziston.");
        }
        return spidRepository.save(spid);
    }

    public void editSpid(long id) throws Exception {
        Optional<Spid> findIfSpidExists = spidRepository.findById(id);

        if(!findIfSpidExists.isPresent()) {
            throw new Exception("Spid-i nuk ekziston.");
        }
        spidRepository.editById(id);
    }

}
