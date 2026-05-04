package com.SpringSeries.Learn.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Entity")
@Data
public class LearnEntity {
    @Id
    private ObjectId id;
    private String name;
}
