package com.SpringSeries.Learn.service;

import com.SpringSeries.Learn.entity.LearnEntity;
import com.SpringSeries.Learn.repository.EntityRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EntityService {

    @Autowired
    private EntityRepository entityRepository;

    public LearnEntity createEntity(LearnEntity e){
        entityRepository.save(e);
        return e;
    }

    public Optional<LearnEntity> getEntity(ObjectId id){
        return entityRepository.findById(id);
    }

    public List<LearnEntity> getAll(){
        System.out.println("Inside");
        return entityRepository.findAll();
    }

    public LearnEntity update(LearnEntity e){
        return entityRepository.save(e);
    }

    public String delete(ObjectId id){
         entityRepository.deleteById(id);
        return "DELETED";
    }


}
