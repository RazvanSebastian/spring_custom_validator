package edu.validation.demo.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import edu.validation.demo.pojo.PojoTest;

@Validated
@Service
public interface IPojoService {

	String validateTest(@Valid PojoTest pojoTest);

}
