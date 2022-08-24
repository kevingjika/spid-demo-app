package com.project.springbootfinalproject.repository;

import com.project.springbootfinalproject.entities.Spid;
import com.project.springbootfinalproject.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpidRepository extends JpaRepository <Spid,Long>{
    Optional<Users> findById (String message);

    @Query("SELECT p FROM Spid p WHERE p.createdBy LIKE CONCAT('%',:message, '%') Or p.status LIKE CONCAT ('%', :query, '%')")
    List <Spid> searchSpid ( String message);

    @Query(value = "SELECT * FROM spid_final_project.spid WHERE status LIKE %:message% Or type LIKE %:message% Or created_by LIKE %:message%", nativeQuery = true)
    List <Spid> searchSpidSQL(@Param("message") String message);


}