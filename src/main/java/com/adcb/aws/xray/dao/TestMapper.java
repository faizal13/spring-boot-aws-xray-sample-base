package com.adcb.aws.xray.dao;

import org.apache.ibatis.annotations.Mapper;

import com.amazonaws.xray.spring.aop.XRayEnabled;

@Mapper
@XRayEnabled
public interface TestMapper {

	 int count(int idx);
	
}
