package edu.validation.demo.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.validation.demo.pojo.PojoTest;
import edu.validation.demo.service.PojoService;

@RestController
public class TestRestController {

	@Autowired
	private PojoService pojoService;

	@GetMapping("/test")
	public ResponseEntity<?> validateInputs(@RequestParam("input1") String input1,
			@RequestParam("input2") String input2) throws Exception {
		PojoTest pojoTest = new PojoTest(input1, input2);
		String pojoString = pojoService.validateTest(pojoTest);

		return new ResponseEntity<String>(pojoString, HttpStatus.OK);
	}

	@PostMapping("/test")
	public ResponseEntity<?> validateRequestBody(@Valid @RequestBody PojoTest input) {
		return new ResponseEntity<String>(input.toString(), HttpStatus.OK);
	}

}
