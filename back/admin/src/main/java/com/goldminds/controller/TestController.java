package com.goldminds.controller;

import com.goldminds.common.controller.AbstractController;
import com.goldminds.common.model.Test;
import com.goldminds.dto.TestDTO;
import com.goldminds.mapper.TestMapper;
import com.goldminds.repository.TestRepository;
import com.goldminds.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bessam on 22/08/2021
 */


@RestController
@RequestMapping("/test")
public class TestController extends AbstractController<TestDTO, Test, TestMapper, TestService, TestRepository> {

	Logger logger = LoggerFactory.getLogger(TestController.class);

	public TestController(TestService service) {
		super(service);
		logger.info("Starting Controller ################## INFO");
		logger.error("Starting Controller ################## ERROR");
		logger.warn("Starting Controller ################## WARN");
		logger.debug("Starting Controller ################## DEBUG");


	}


}
