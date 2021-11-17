package com.goldminds.common.controller;

import com.goldminds.common.dto.AbstractDTO;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.Collection;

public interface PersistableController <DTO extends AbstractDTO> {

    ResponseEntity<DTO> save(DTO dto) throws URISyntaxException;
    ResponseEntity<Collection<DTO>> saveAll(Collection<DTO> list);
}
