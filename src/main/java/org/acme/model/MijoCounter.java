package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mijo_counter")
public class MijoCounter extends PanacheEntity {
    
    @Column(name = "count_value")
    public int count;
    
    @Column(unique = true)
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


