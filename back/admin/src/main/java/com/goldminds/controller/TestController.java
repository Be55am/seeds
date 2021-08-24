package com.goldminds.controller;

import com.goldminds.dto.TestDTO;
import com.goldminds.service.TestService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bessam on 22/08/2021
 */

// todo the route here is not concidered

@RestController("/test")
public class TestController extends com.goldminds.common.controller.AbstractController<TestDTO, TestService> {

	public TestController(TestService service) {
		super(service, LoggerFactory.getLogger("Test Controller "));
		System.out.println("Initializing Test Controller");

	}


}
