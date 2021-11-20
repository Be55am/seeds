package com.goldminds.common.controller;

import org.springframework.http.ResponseEntity;

public interface UpdatableController<DTO> {

    ResponseEntity<DTO> update(Long id, DTO dto);
}
