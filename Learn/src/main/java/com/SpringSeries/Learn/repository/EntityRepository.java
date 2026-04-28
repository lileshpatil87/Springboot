package com.SpringSeries.Learn.repository;

import com.SpringSeries.Learn.entity.LearnEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

public interface EntityRepository extends MongoRepository<LearnEntity, ObjectId> {
}
