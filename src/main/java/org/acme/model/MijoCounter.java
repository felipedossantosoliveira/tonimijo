package org.acme.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "mijocounter")
public class MijoCounter extends PanacheMongoEntity {
    public int count;
    public String name;

    public MijoCounter() { }

    public MijoCounter(int count, String name) {
        this.count = count;
        this.name = name;
    }

    public final int getCount() { return count; }

    public final String getName() { return name; }

    public final void setCount(int count) { this.count = count; }

    public final void setName(String name) { this.name = name; }
}


