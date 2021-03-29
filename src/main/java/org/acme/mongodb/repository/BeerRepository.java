package org.acme.mongodb.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import javax.enterprise.context.ApplicationScoped;
import org.acme.mongodb.model.Beer;

@ApplicationScoped
public class BeerRepository implements PanacheMongoRepository<Beer> {

    public Beer findByName(String name){
        return find("name", name).firstResult();
    }

}
