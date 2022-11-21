package com.demo.spring.repository;
import com.demo.spring.model.Actor;

import java.util.List;
public interface ActorRepository {
    public List<Actor> findAllActors();
}
