package com.SpringSeries.Learn.controller;

import com.SpringSeries.Learn.entity.LearnEntity;
import com.SpringSeries.Learn.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("learn")
public class LearnController {

    @Autowired
    private EntityService entityService;

    @GetMapping("all")
    public List<LearnEntity> getAll() {
        return entityService.getAll();
    }
    
    @GetMapping("{id}")
    public Optional<LearnEntity> get(@PathVariable String id){
        return entityService.getEntity(id);
    }

    @PostMapping
    public LearnEntity post(@RequestBody LearnEntity value) {
        return entityService.createEntity(value);
    }

    @PutMapping("")
    public LearnEntity put(@RequestBody LearnEntity value) {
        return entityService.update(value);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable String id) {
        return entityService.delete(id);
    }

}
