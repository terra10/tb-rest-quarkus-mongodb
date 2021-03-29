package org.acme.mongodb.model;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import java.util.Objects;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

@MongoEntity
public class Beer extends PanacheMongoEntity {

    public Beer() {
    }

    private String name;

    private Brewery brewery;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Beer beer = (Beer) o;
        return Objects.equals(id, beer.id) &&
                Objects.equals(name, beer.name) &&
                Objects.equals(brewery, beer.brewery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brewery);
    }
}
