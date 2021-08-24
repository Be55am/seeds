package com.goldminds.common.service;


import com.goldminds.common.dto.AbstractDTO;
import com.goldminds.common.mapper.AbstractMapper;
import com.goldminds.common.model.AbstractEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public abstract class AbstractService<
		DTO extends AbstractDTO,
		ENTITY extends AbstractEntity<Long>,
		MAPPER extends AbstractMapper<ENTITY, DTO>,
		REPOSITORY extends JpaRepository<ENTITY, Long>> {

	private REPOSITORY repository;
	private MAPPER mapper;

	public DTO save(DTO dto) {
		return mapper.toDTO(repository.save(mapper.toEntity(dto)));
	}

	public List<DTO> saveAll(Collection<DTO> collection) {
		return repository.saveAll(collection.parallelStream().map(l -> mapper.toEntity(l)).collect(Collectors.toList()))
				.stream()
				.map(entity -> mapper.toDTO(entity))
				.collect(Collectors.toList());

	}

	public List<DTO> findAll() {
		return repository.findAll().parallelStream().map(entity -> mapper.toDTO(entity)).collect(Collectors.toList());
	}


	public Optional<DTO> findById(long id) {
		return repository.findById(id).map(entity -> mapper.toDTO(entity));
	}


	public Page<DTO> findAll(Pageable pageable) {
		return repository.findAll(pageable).map(entity -> mapper.toDTO(entity));
	}


	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	public void removeById(long id) {
		repository.deleteById(id);
	}

	public DTO update(DTO dto) {
		if (repository.existsById(dto.getId()))
			return mapper.toDTO(repository.save(mapper.toEntity(dto)));
		else throw new EntityNotFoundException();
	}
}
