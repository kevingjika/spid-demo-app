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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpidService implements SpidServiceImpl{

    SpidRepository spidRepository;
    UsersRepository usersRepository;

    SpidService(SpidRepository spidRepository, UsersRepository usersRepository){
        this.spidRepository = spidRepository;
        this.usersRepository = usersRepository;
    }

    public Spid createSpid(Spid spid) throws Exception{
        spid.setStatus(Status.PENDING.name());
        Optional<Users> findIfUsersExists = usersRepository.findById(spid.getUsers().getId());
        if (!findIfUsersExists.isPresent()){
            throw new Exception("User-i qe kerkoni nuk ekziston.");
        } else {
            spid.setUsers(findIfUsersExists.get());
            findIfUsersExists.get().setCreatedBy(spid.getCreatedBy());
        }
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

    public List <Spid> findAll() {
        return spidRepository.findAll();
    }



    public Spid findSpidById(long id) throws Exception{
        Optional<Spid> findIfSpidExists = spidRepository.findById(id);
        if(!findIfSpidExists.get().getStatus().equals(Status.PENDING.name())) {
            throw new Exception ("Spid-i nuk do te kthehet.");
        }
        return findIfSpidExists.get();
    }

    public Spid changeSpidStatus(long id) throws Exception{
        Optional<Spid> findIfSpidExists = spidRepository.findById(id);
        if(!findIfSpidExists.get().getStatus().equals(Status.PENDING.name())) {
            throw new Exception ("Statusi i spid-it nuk do te ndryshohet.");
        }
            findIfSpidExists.get().setStatus(Status.READY_FOR_REVIEW.name());
            return spidRepository.save(findIfSpidExists.get());
    }


    @Override
    public List<Spid> searchSpid(String message) {
        List<Spid> findIfSpidExists = spidRepository.searchSpidSQL(message);
        if(!findIfSpidExists.isEmpty()) {
            return findIfSpidExists;
        }
        return spidRepository.findAll();
    }
}
