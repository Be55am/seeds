package com.goldminds.common.service;

import com.goldminds.common.dto.AbstractDTO;
import com.goldminds.common.mapper.AbstractMapper;
import com.goldminds.common.model.AbstractEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
public class UpdatableImpl<DTO extends AbstractDTO,
        ENTITY extends AbstractEntity<Long>,
        MAPPER extends AbstractMapper<ENTITY, DTO>,
        REPOSITORY extends JpaRepository<ENTITY, Long>
        > implements Updatable<DTO> {

    private REPOSITORY repository;
    private MAPPER mapper;

    @Override
    public DTO update(DTO dto) {
        if (repository.existsById(dto.getId()))
            return mapper.toDTO(repository.save(mapper.toEntity(dto)));
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ENTITY WITH ID " + dto.getId() + " IS NOT FOUND !");
    }
}
