package com.project.springbootfinalproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Spid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private LocalDateTime createdAt;
    private String createdBy;
    private String status;
    private String type;
    @OneToOne(cascade = CascadeType.ALL)
    private Users users;
}
