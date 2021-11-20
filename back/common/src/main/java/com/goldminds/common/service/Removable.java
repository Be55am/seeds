package com.goldminds.common.service;


import com.goldminds.common.dto.AbstractDTO;

public interface Removable<DTO extends AbstractDTO> {
    void removeById(final long id);
}
