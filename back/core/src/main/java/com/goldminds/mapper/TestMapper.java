package com.goldminds.mapper;

import com.goldminds.common.mapper.AbstractMapper;
import com.goldminds.common.model.Test;
import com.goldminds.dto.TestDTO;
import org.springframework.stereotype.Component;

/**
 * @author bessam on 24/08/2021
 */

@Component
public class TestMapper implements AbstractMapper<Test, TestDTO> {

	@Override
	public TestDTO toDTO(Test entity) {
		return new TestDTO(entity.getTest());
	}

	@Override
	public Test toEntity(TestDTO dto) {
		return new Test(dto.getTest());
	}
}
