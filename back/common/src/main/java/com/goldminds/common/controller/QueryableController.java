package com.goldminds.common.controller;

import com.goldminds.common.dto.AbstractDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface QueryableController <DTO extends AbstractDTO> {

    ResponseEntity<DTO> findById(Long id);

    ResponseEntity<Collection<DTO>> findAll();

    ResponseEntity<Page<DTO>> findAll(Pageable pageable);
}
