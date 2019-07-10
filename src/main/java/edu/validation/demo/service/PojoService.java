package edu.validation.demo.service;

import org.springframework.stereotype.Component;

import edu.validation.demo.pojo.PojoTest;

@Component
public class PojoService implements IPojoService{

	public String validateTest(PojoTest pojoTest) {
		return pojoTest.toString();
	}

}
