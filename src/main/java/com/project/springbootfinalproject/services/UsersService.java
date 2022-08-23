package com.project.springbootfinalproject.services;

import com.project.springbootfinalproject.entities.Spid;
import com.project.springbootfinalproject.entities.Status;
import com.project.springbootfinalproject.repository.SpidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.springbootfinalproject.entities.Users;
import com.project.springbootfinalproject.exceptions.NoUsersFoundException;
import com.project.springbootfinalproject.repository.UsersRepository;

import java.util.Optional;

@Service
public class UsersService {

    UsersRepository usersRepository;

    UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public Users createUser (Users users) throws Exception {
        Optional<Users> findIfUserExists = usersRepository.findByUsername(users.getUsername());

        if(findIfUserExists.isPresent()){
            throw new NoUsersFoundException("User-i ekziston.");
        }
        return usersRepository.save(users);
    }

    public Optional<Users> findByName(String name) {
        return usersRepository.findByName(name);
    }

    public Optional<Users> findById(long id){
        return usersRepository.findById(id);
    }

    public void editUser(long id) throws Exception {
        Optional<Users>  findIfUsersExists = usersRepository.findById(id);

        if(!findIfUsersExists.isPresent()) {
            throw new Exception("User-i nuk ekziston.");
        }
        usersRepository.save(findIfUsersExists.get());
    }

    public void deleteUser(long id) throws Exception{
        Optional<Users> findIfUsersExists = usersRepository.findById(id);
        if(!findIfUsersExists.isPresent()) {
            throw new Exception ("User-i nuk do te fshihet.");
        }
        usersRepository.deleteById(id);
    }
}
