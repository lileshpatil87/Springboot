package com.SpringSeries.Learn.controller;

import com.SpringSeries.Learn.entity.LearnEntity;
import com.SpringSeries.Learn.service.EntityService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("learn")
public class LearnController {

    @Autowired
    private EntityService entityService;

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        List<LearnEntity> le = entityService.getAll();
        if(!le.isEmpty()){
            return new ResponseEntity<>( le, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<?> get(@PathVariable ObjectId id){
        Optional<LearnEntity> le =  entityService.getEntity(id);
        if(!le.isEmpty()){
            return new ResponseEntity<>(le,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody LearnEntity value) {
        try {
            LearnEntity le = entityService.createEntity(value);
            return new ResponseEntity<LearnEntity>(le,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("")
    public ResponseEntity<?> put(@RequestBody LearnEntity value) {
        LearnEntity le= entityService.update(value);
        if(le.getId() != null){
            return new ResponseEntity<LearnEntity>(le,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable ObjectId id) {
        if(entityService.delete(id) != null){
            return new ResponseEntity<>("DELETED",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
