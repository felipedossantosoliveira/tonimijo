package org.acme.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.MijoCounter;

import java.util.Optional;

@ApplicationScoped
public class MijoCounterRepository implements PanacheMongoRepository<MijoCounter> {

    public final void save(final MijoCounter counter, final boolean hasCount) {
        Optional<MijoCounter> optional = this.findByName(counter.name);
        if (optional.isPresent()) {
            if (hasCount) {
                // Se count foi especificado no DTO, substitui o valor
                optional.get().count = counter.count;
            } else {
                // Se count não foi especificado, incrementa
                optional.get().count += 1;
            }
            this.update(optional.get());
        } else {
            // Novo registro: se não tem count, começa com 1
            if (!hasCount) {
                counter.count = 1;
            }
            this.persist(counter);
        }
    }

    public final Optional<MijoCounter> findByName(final String name) {
        return this.find("name", name).firstResultOptional();
    }
}
