package com.goldminds.core.service;

import com.goldminds.common.model.Test;
import com.goldminds.common.service.AbstractService;
import com.goldminds.core.dto.TestDTO;
import com.goldminds.core.mapper.TestMapper;
import com.goldminds.core.repository.TestRepository;
import org.springframework.stereotype.Service;

/**
 * @author bessam on 22/08/2021
 */

@Service
public class TestService extends AbstractService<TestDTO, Test, TestMapper, TestRepository> {

	public TestService(TestRepository repository, TestMapper mapper) {
		super(repository, mapper);
	}
}
