package com.goldminds.common.controller;

import com.goldminds.common.dto.AbstractDTO;
import com.goldminds.common.service.Queryable;
import com.goldminds.common.service.Updatable;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
public class UpdatableControllerImpl<DTO extends AbstractDTO, SERVICE extends Updatable<DTO>>
        implements UpdatableController<DTO> {

    private SERVICE service;

    /**
     * {@code PUT  /:id} : Updates an existing entity.
     *
     * @param id     the id of the entity to save.
     * @param entity the entity to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated entity,
     * or with status {@code 400 (Bad Request)} if the entity is not valid,
     * or with status {@code 500 (Internal Server Error)} if the entity couldn't be updated.
     */
    @Override
    public ResponseEntity<DTO> update(Long id, DTO entity) {
        if (entity.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "INVALID ID");
        }
        DTO result = service.update(entity);
        return ResponseEntity.ok(service.update(entity));
    }


}
