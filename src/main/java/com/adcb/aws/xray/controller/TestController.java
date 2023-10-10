package com.adcb.aws.xray.controller;

import com.adcb.aws.xray.dao.TestMapper;
import com.adcb.aws.xray.model.AccountDetail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.adcb.aws.xray.service.TestService;

import java.util.Optional;

@RestController
@XRayEnabled
@RequestMapping("/api")
public class TestController {


	private static final Logger LOG = LogManager.getLogger(TestController.class);
	@Autowired
	private TestService testService;

	@Autowired
	private TestMapper testMapper;

	@GetMapping("/{accountNo}")
	@ResponseBody
	public AccountDetail getAccountDetails(@PathVariable("accountNo") String accountNo) {
		ThreadContext.put("accountNo", accountNo);
		LOG.info("fetching account details for account ");
		Optional<AccountDetail> accountDetail = testService.getAccount(accountNo);
		LOG.info("Details of account {}", accountDetail);
		ThreadContext.clearAll();
		return accountDetail.orElse(AccountDetail.builder().build());
	}
	
	@GetMapping("/testxray")
	public String testxray() {
		
		//testService.test("test_bucket");
		//testMapper.count(1);
		return "Xray HERE";
	}
	
}
