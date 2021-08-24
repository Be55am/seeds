package com.goldminds.service;

import com.goldminds.common.model.Test;
import com.goldminds.common.service.AbstractService;
import com.goldminds.dto.TestDTO;
import com.goldminds.mapper.TestMapper;
import com.goldminds.repository.TestRepository;
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
