package org.acme.mapper;

import org.acme.dto.MijoCounterDTO;
import org.acme.model.MijoCounter;

public final class MijoCounterMapper {

    private MijoCounterMapper() { throw new IllegalStateException("Utility class");}

    public static MijoCounterDTO toDTO(MijoCounter counter) {
        return new MijoCounterDTO(counter.count, counter.name);
    }

    public static MijoCounter toEntity(MijoCounterDTO dto) {
        MijoCounter counter =  new MijoCounter();
        counter.setCount(dto.count() != null ? dto.count() : 0);
        counter.setName(dto.name());
        return counter;
    }

    public static boolean hasCount(MijoCounterDTO dto) {
        return dto.count() != null;
    }
}
