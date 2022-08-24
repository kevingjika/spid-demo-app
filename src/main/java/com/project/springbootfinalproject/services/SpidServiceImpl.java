package com.project.springbootfinalproject.services;

import com.project.springbootfinalproject.entities.Spid;

import java.util.List;

public interface SpidServiceImpl {
    List<Spid> searchSpid(String message);
}
