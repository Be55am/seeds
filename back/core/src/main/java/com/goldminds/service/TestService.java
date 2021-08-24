package com.goldminds.service;

import com.goldminds.common.service.AbstractService;
import com.goldminds.dto.TestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author bessam on 22/08/2021
 */

@Service
public class TestService implements AbstractService<TestDTO> {
	@Override
	public TestDTO save(TestDTO dto) {
		return null;
	}

	@Override
	public List<TestDTO> saveAll(Iterable<TestDTO> list) {
		return null;
	}

	@Override
	public List<TestDTO> findAll() {
		System.out.println("Loggin from service ...");
		return Arrays.asList(new TestDTO("Test"));
	}

	@Override
	public Optional<TestDTO> findById(long id) {
		return Optional.empty();
	}

	@Override
	public Page<TestDTO> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		return false;
	}

	@Override
	public Void removeById(long id) {
		return null;
	}

	@Override
	public TestDTO update(TestDTO dto) {
		return null;
	}
}
