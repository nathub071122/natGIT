package com.demo.spring.service;
import com.demo.spring.model.Actor;
import com.demo.spring.repository.ActorRepository;

import java.util.List;
public class ActorServiceImpl implements  ActorService{
//   Perform the dependency injection
    ActorRepository actorRepository;
    @Override
    public List<Actor> getAllActors() {
        return null;
    }
}
