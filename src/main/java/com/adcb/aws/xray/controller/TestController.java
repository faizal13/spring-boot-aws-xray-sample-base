package com.adcb.aws.xray.controller;

import com.adcb.aws.xray.dao.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.adcb.aws.xray.service.TestService;

@RestController
@XRayEnabled
@RequestMapping("/api")
public class TestController {

	@Autowired
	private TestService testService;

	@Autowired
	private TestMapper testMapper;
	
	@GetMapping("/testxray")
	public String testxray() {
		
		//testService.test("test_bucket");
		//testMapper.count(1);
		return "Xray HERE";
	}
	
}
