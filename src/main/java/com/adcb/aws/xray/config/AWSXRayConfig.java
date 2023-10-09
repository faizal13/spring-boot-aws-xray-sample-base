package com.adcb.aws.xray.config;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Optional;

import javax.servlet.Filter;

import com.adcb.aws.xray.exception.ApplicationNameNullException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import com.amazonaws.xray.AWSXRay;
import com.amazonaws.xray.AWSXRayRecorderBuilder;
import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;
import com.amazonaws.xray.slf4j.SLF4JSegmentListener;
import com.amazonaws.xray.strategy.sampling.CentralizedSamplingStrategy;

import lombok.extern.slf4j.Slf4j;

@Configuration
public class AWSXRayConfig {
	
	@Value("${spring.application.name}")
	private String AWSXRAY_SEGMENT_NAME;
	

	@Bean
	public Filter TracingFilter() {
		return new AWSXRayServletFilter(
				Optional.ofNullable(AWSXRAY_SEGMENT_NAME)
						.orElseThrow(()->new ApplicationNameNullException())
		);
	}
	
}