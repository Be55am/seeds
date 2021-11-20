package com.goldminds.common.controller;

import com.goldminds.common.dto.AbstractDTO;
import org.springframework.http.ResponseEntity;

public interface RemovableController<DTO extends AbstractDTO> {

    ResponseEntity<Void> delete(Long id);
}
