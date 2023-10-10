package com.adcb.aws.xray.service;

import com.adcb.aws.xray.dao.TestMapper;
import com.adcb.aws.xray.model.AccountDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.xray.interceptors.TracingInterceptor;
import com.amazonaws.xray.spring.aop.XRayEnabled;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

//@Slf4j
@Service
@Transactional
@XRayEnabled
public class TestService {

	private static final Logger LOG = LogManager.getLogger(TestService.class);

	@Autowired
	private TestMapper testMapper;
	
	public void test(String bucket) {
		/*S3Client s3Client = S3Client.builder()
									.credentialsProvider(ProfileCredentialsProvider.create("default"))
									.region(Region.AP_NORTHEAST_2)
									.overrideConfiguration(ClientOverrideConfiguration.builder()
											.addExecutionInterceptor(new TracingInterceptor())
											.build())
								.build();		
		s3Client.listBuckets();		*/
		testMapper.count(1);
		LOG.debug("Serviced");
	}



	public Optional<AccountDetail> getAccount(final String accountNo) {
		// simulating an account not exists scenario
		if(accountNo.endsWith("000")){
			LOG.error("Account not found:: {}", accountNo);
			return Optional.empty();
		}
		return Optional.ofNullable(AccountDetail.builder().accountHolder("Jack Melon")
				.accountNo("GWR" + accountNo)
				.balance(19000.89)
				.currency("USD")
				.openingDate("12/01/2015")
				.build());

	}
	
}
