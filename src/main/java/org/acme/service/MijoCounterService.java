package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.MijoCounterDTO;
import org.acme.mapper.MijoCounterMapper;
import org.acme.model.MijoCounter;
import org.acme.repository.MijoCounterRepository;

@ApplicationScoped
public class MijoCounterService {

    @Inject
    MijoCounterRepository mijoCounterRepository;

    public void save(MijoCounterDTO dto) {
        MijoCounter counter = MijoCounterMapper.toEntity(dto);
        boolean hasCount = MijoCounterMapper.hasCount(dto);
        this.mijoCounterRepository.save(counter, hasCount);
    }
}
