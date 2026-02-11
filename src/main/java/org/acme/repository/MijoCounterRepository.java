package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.model.MijoCounter;

import java.util.Optional;

@ApplicationScoped
public class MijoCounterRepository implements PanacheRepository<MijoCounter> {

    @Transactional
    public final MijoCounter save(final MijoCounter counter, final boolean hasCount) {
        Optional<MijoCounter> optional = this.findByName(counter.name);
        if (optional.isPresent()) {
            if (hasCount) {
                optional.get().count = counter.count;
                return optional.get();
            } else {
                optional.get().count += 1;
                return optional.get();
            }
        } else {
            if (!hasCount) {
                counter.count = 1;
            }
            this.persist(counter);
            return counter;
        }
    }

    public final Optional<MijoCounter> findByName(final String name) {
        return this.find("name", name).firstResultOptional();
    }
}
