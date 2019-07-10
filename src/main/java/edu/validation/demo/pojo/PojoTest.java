package edu.validation.demo.pojo;

import javax.validation.constraints.Size;

import edu.validation.demo.validator.ValidString;

public class PojoTest {

	@ValidString(message = "Input 1 must not be null or empty") 
	private String input1;

	@Size(min = 3, max = 3, message = "Size of 3 reuired for input2")
	private String input2;

	public PojoTest() {
		super();
	}

	public PojoTest(String input1, String input2) {
		super();
		this.input1 = input1;
		this.input2 = input2;
	}

	public String getInput1() {
		return input1;
	}

	public void setInput1(String input1) {
		this.input1 = input1;
	}

	public String getInput2() {
		return input2;
	}

	public void setInput2(String input2) {
		this.input2 = input2;
	}

	@Override
	public String toString() {
		return "PojoTest [input1=" + input1 + ", input2=" + input2 + "]";
	}

}
