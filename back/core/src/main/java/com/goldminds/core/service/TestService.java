package com.goldminds.core.service;

import com.goldminds.common.model.Test;
import com.goldminds.common.service.Persistable;
import com.goldminds.common.service.PersistableImpl;
import com.goldminds.common.service.Queryable;
import com.goldminds.common.service.QueryableImpl;
import com.goldminds.core.dto.TestDTO;
import com.goldminds.core.mapper.TestMapper;
import com.goldminds.core.repository.TestRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author bessam on 22/08/2021
 */

@Service
public class TestService implements Persistable<TestDTO>, Queryable<TestDTO> {

	private final PersistableImpl<TestDTO,Test,TestMapper,TestRepository> persistable;
	private final QueryableImpl<TestDTO, Test, TestMapper, TestRepository> queryable;

	public TestService(TestRepository testRepository, TestMapper testMapper) {
		this.persistable = new PersistableImpl<>(testRepository,testMapper);
		this.queryable = new QueryableImpl<>(testRepository, testMapper);
	}

	@Override
	public TestDTO save(TestDTO dto) {
		return persistable.save(dto);
	}

	@Override
	public Collection<TestDTO> saveAll(Collection<TestDTO> list) {
		return persistable.saveAll(list);
	}

	@Override
	public List<TestDTO> findAll() {
		return queryable.findAll();
	}

	@Override
	public Optional<TestDTO> findById(long id) {
		return queryable.findById(id);
	}

	@Override
	public Page<TestDTO> findAll(Pageable pageable) {
		return queryable.findAll(pageable);
	}

	@Override
	public boolean existsById(Long id) {
		return queryable.existsById(id);
	}
}
