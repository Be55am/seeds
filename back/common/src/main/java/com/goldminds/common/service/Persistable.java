package com.goldminds.common.service;


import com.goldminds.common.dto.AbstractDTO;

import java.util.Collection;
import java.util.List;

public interface Persistable<DTO extends AbstractDTO> {

	DTO save(final DTO dto);

	Collection<DTO> saveAll(final Collection<DTO> list);
}
