package com.goldminds.admin.controller;

import com.goldminds.common.controller.AbstractController;
import com.goldminds.common.model.Test;
import com.goldminds.core.dto.TestDTO;
import com.goldminds.core.mapper.TestMapper;
import com.goldminds.core.repository.TestRepository;
import com.goldminds.core.service.TestService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author bessam on 22/08/2021
 */


@RestController
@RequestMapping("/test")
public class TestController extends AbstractController<TestDTO, Test, TestMapper, TestService, TestRepository> {

	public TestController(TestService service, Logger logger) {
		super(service, logger);
	}


}
