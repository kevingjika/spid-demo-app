package com.project.springbootfinalproject.repository;

import com.project.springbootfinalproject.entities.Spid;
import com.project.springbootfinalproject.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpidRepository extends JpaRepository <Spid,Long>{
    Optional<Users> findById (String message);
}