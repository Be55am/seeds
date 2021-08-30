package com.goldminds.core.mapper;

import com.goldminds.common.mapper.AbstractMapper;
import com.goldminds.common.model.Test;
import com.goldminds.core.dto.TestDTO;
import org.mapstruct.Mapper;

/**
 * @author bessam on 24/08/2021
 */

@Mapper
public interface TestMapper extends AbstractMapper<Test, TestDTO> {

	@Override
	public TestDTO toDTO(Test entity);

	@Override
	public Test toEntity(TestDTO dto);
}
