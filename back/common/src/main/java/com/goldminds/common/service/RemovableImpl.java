package com.goldminds.common.service;

import com.goldminds.common.dto.AbstractDTO;
import com.goldminds.common.model.AbstractEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

@AllArgsConstructor
public class RemovableImpl<
        DTO extends AbstractDTO,
        ENTITY extends AbstractEntity<Long>,
        REPOSITORY extends JpaRepository<ENTITY, Long>> implements Removable<DTO> {

    private REPOSITORY repository;


    @Override
    public void removeById(long id) {
        repository.deleteById(id);
    }
}
