package com.goldminds.common.mapper;

import com.goldminds.common.model.AbstractEntity;

import java.io.Serializable;

/**
 * @author bessam on 21/08/2021
 */

public interface AbstractMapper<E extends AbstractEntity<Long>, T> {

	T toDTO(E entity);

	E toEntity(T dto);
}
