package com.goldminds.controller;

import com.goldminds.common.controller.AbstractController;
import com.goldminds.common.model.Test;
import com.goldminds.dto.TestDTO;
import com.goldminds.mapper.TestMapper;
import com.goldminds.repository.TestRepository;
import com.goldminds.service.TestService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bessam on 22/08/2021
 */

// todo the route here is not concidered

@RestController("/test")
public class TestController extends AbstractController<TestDTO, Test, TestMapper, TestService, TestRepository> {

	public TestController(TestService service) {
		super(service);
		System.out.println("Initializing Test Controller");

	}


}
