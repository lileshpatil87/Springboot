package com.SpringSeries.Learn.controller;

import com.SpringSeries.Learn.entity.LearnEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("learn")
public class LearnController {

    private final Map<Integer, LearnEntity> entity = new HashMap<>();

    @GetMapping
    public List<LearnEntity> get() {
        return new ArrayList<>(entity.values());
    }

    @PostMapping
    public LearnEntity createEntity(@RequestBody LearnEntity value) {
        entity.put(value.getId(), value);
        return value;
    }

    @GetMapping("/{id}")
    public LearnEntity getById(@PathVariable int id) {
        return entity.get(id);
    }

    @PutMapping("/{id}")
    public LearnEntity updateEntity(@PathVariable int id,@RequestBody LearnEntity value) {
        return entity.replace(id,value);
    }

    @DeleteMapping("/{id}")
    public LearnEntity deleteEntity(@PathVariable int id) {
        return entity.remove(id);
    }
}
