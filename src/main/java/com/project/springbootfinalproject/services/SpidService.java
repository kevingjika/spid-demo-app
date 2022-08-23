package com.project.springbootfinalproject.services;

import com.project.springbootfinalproject.entities.Spid;
import com.project.springbootfinalproject.entities.Users;
import com.project.springbootfinalproject.exceptions.NoUsersFoundException;
import com.project.springbootfinalproject.repository.SpidRepository;
import com.project.springbootfinalproject.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

@Service
public class SpidService {


    SpidRepository spidRepository;

    SpidService(SpidRepository spidRepository){
        this.spidRepository = spidRepository;
    }

    public Spid createSpid(Spid spid) throws Exception {
        spid.setStatus(Status.PENDING.name());
        return spidRepository.save(spid);
    }

    public Spid editSpid(Spid spid) throws Exception {
        Optional<Spid> findIfSpidExists = spidRepository.findById(spid.getId());

        if(!findIfSpidExists.isPresent()) {
            throw new Exception("Spid-i nuk ekziston.");
        }
        return spidRepository.save(findIfSpidExists.get());
    }

    public void deleteSpid(long id) throws Exception {
        Optional<Spid> findIfSpidExists = spidRepository.findById(id);
        if(!findIfSpidExists.get().getStatus().equals(Status.PENDING.name())) {
            throw new Exception ("Spid-i nuk do te fshihet.");
        }
        spidRepository.deleteById(id);
    }

}
