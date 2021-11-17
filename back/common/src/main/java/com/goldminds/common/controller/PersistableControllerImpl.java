package com.goldminds.common.controller;

import com.goldminds.common.dto.AbstractDTO;
import com.goldminds.common.service.Persistable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

public class PersistableControllerImpl<DTO extends AbstractDTO,
        SERVICE extends Persistable<DTO>> implements PersistableController<DTO> {

    private SERVICE service;

    /**
     * {@code POST  /habitations} : Create a new entity.
     *
     * @param entity the entity to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new habitationDTO, or with status {@code 400 (Bad Request)} if the entity has already an ID.
     * @throws ResponseStatusException if the Location URI syntax is incorrect.
     */

    @Override
    @PostMapping
    public ResponseEntity<DTO> save(@RequestBody DTO entity) throws ResponseStatusException, URISyntaxException {
        if (entity.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "THE ID SHOULD BE NULL");
        } else {
            DTO result = service.save(entity);
            return ResponseEntity
                    .created(new URI("/" + result.getId()))
                    .body(result);
        }

    }

    @Override
    public ResponseEntity<Collection<DTO>> saveAll(Collection<DTO> list) {
        return null;
    }
}
