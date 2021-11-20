package com.goldminds.common.service;

import com.goldminds.common.dto.AbstractDTO;
import com.goldminds.common.mapper.AbstractMapper;
import com.goldminds.common.model.AbstractEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PersistableImpl
        <DTO extends AbstractDTO,
                ENTITY extends AbstractEntity<Long>,
                MAPPER extends AbstractMapper<ENTITY, DTO>,
                REPOSITORY extends JpaRepository<ENTITY, Long>> implements Persistable<DTO> {

    private REPOSITORY repository;
    private MAPPER mapper;

    @Override
    public DTO save(DTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }


    @Override
    public List<DTO> saveAll(Collection<DTO> collection) {
        return repository.saveAll(collection.parallelStream().map(l -> mapper.toEntity(l)).collect(Collectors.toList()))
                .stream()
                .map(entity -> mapper.toDTO(entity))
                .collect(Collectors.toList());

    }
}
