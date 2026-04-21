package com.SpringSeries.Learn.controller;

import com.SpringSeries.Learn.entity.LearnEntity;
import com.SpringSeries.Learn.service.EntityService;
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

    @Autowired
    private EntityService entityService;

    @PostMapping
    public LearnEntity post(@RequestBody LearnEntity value) {
        return entityService.createEntity(value);
    }

}
