package com.goldminds.common.controller;

import com.goldminds.common.Util.ResponseUtil;
import com.goldminds.common.dto.AbstractDTO;
import com.goldminds.common.service.Queryable;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
public class QueryableControllerImpl<
        DTO extends AbstractDTO,
        SERVICE extends Queryable<DTO>
        > implements QueryableController<DTO> {

    private SERVICE service;


    /**
     * {@code GET  /:id} : get the entity id.
     *
     * @param id the id of the DTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the addressDTO, or with status {@code 404 (Not Found)}.
     */
    @Override
    public ResponseEntity<DTO> findById(Long id) {
        Optional<DTO> dto = service.findById(id);
        return ResponseUtil.wrapOrNotFound(dto);
    }


    @Override
    public ResponseEntity<Collection<DTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }


    /**
     * {@code GET  /habitations} : get all the entities.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of habitations in body.
     */
    @Override
    public ResponseEntity<Page<DTO>> findAll(Pageable pageable) {
        Page<DTO> page = null;
        try {
            page = service.findAll(pageable);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return ResponseEntity.ok(page);
    }
}
