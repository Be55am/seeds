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





	public void removeById(long id) {
		repository.deleteById(id);
	}

	public DTO update(DTO dto) {
		if (repository.existsById(dto.getId()))
			return mapper.toDTO(repository.save(mapper.toEntity(dto)));
		else throw new EntityNotFoundException();
	}
}
