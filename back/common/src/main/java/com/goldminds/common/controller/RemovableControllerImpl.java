package com.goldminds.common.controller;

import com.goldminds.common.dto.AbstractDTO;
import com.goldminds.common.service.Removable;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class RemovableControllerImpl<DTO extends AbstractDTO, SERVICE extends Removable<DTO>> implements RemovableController<DTO> {

    private SERVICE service;


    /**
     * {@code DELETE  /:id} : delete the "id" entity.
     *
     * @param id the id of the entity to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.removeById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

}
