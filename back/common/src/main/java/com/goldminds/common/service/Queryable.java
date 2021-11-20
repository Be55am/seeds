package com.goldminds.common.service;

import com.goldminds.common.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface Queryable<DTO extends AbstractDTO> {

	List<DTO> findAll();

	Optional<DTO> findById(final long id);

	Page<DTO> findAll(final Pageable pageable);

	boolean existsById(Long id);
}
