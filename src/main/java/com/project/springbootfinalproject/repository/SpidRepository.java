package com.project.springbootfinalproject.repository;

import com.project.springbootfinalproject.entities.Spid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpidRepository extends JpaRepository <Spid,Long>{

}
