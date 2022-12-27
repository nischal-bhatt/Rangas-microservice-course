package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

public class MessageBean {

	private String input;
	private int input1;

	public MessageBean(String input, int input1)
	{
		this.input = input;
		this.input1 = input1;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public int getInput1() {
		return input1;
	}

	public void setInput1(int input1) {
		this.input1 = input1;
	}

	@Override
	public String toString() {
		return "MessageBean [input=" + input + ", input1=" + input1 + "]";
	}
	
	
}
