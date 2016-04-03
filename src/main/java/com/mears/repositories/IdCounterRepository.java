package com.mears.repositories;

import com.mears.entities.IdCounter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface IdCounterRepository extends MongoRepository<IdCounter, String>{

    @Query("{_id : ?0}")
    IdCounter findById(String counterId);
}