package com.goldminds.common.service;

import com.goldminds.common.dto.AbstractDTO;
import com.goldminds.common.mapper.AbstractMapper;
import com.goldminds.common.model.AbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QueryableImpl
        <DTO extends AbstractDTO,
                ENTITY extends AbstractEntity<Long>,
                MAPPER extends AbstractMapper<ENTITY, DTO>,
                REPOSITORY extends JpaRepository<ENTITY, Long>>  implements Queryable<DTO> {

    private REPOSITORY repository;
    private MAPPER mapper;

    @Override
    public List<DTO> findAll() {
        return repository.findAll().parallelStream().map(entity -> mapper.toDTO(entity)).collect(Collectors.toList());
    }


    @Override
    public Optional<DTO> findById(long id) {
        return repository.findById(id).map(entity -> mapper.toDTO(entity));
    }


    @Override
    public Page<DTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(entity -> mapper.toDTO(entity));
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

}
