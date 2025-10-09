package com.app_parents_backend.backend.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app_parents_backend.backend.model.prueba;
import com.app_parents_backend.backend.repository.pruebaRepository;

@RestController
@RequestMapping("/prueba")
public class ConSql  {

    @Autowired
    private pruebaRepository repo;

    // POST /prueba
    @PostMapping
    public prueba crear(@RequestBody prueba p) {
        return repo.save(p);
    }

    // GET /prueba
    @GetMapping
    public List<prueba> listar() {
        return repo.findAll();
    }
}