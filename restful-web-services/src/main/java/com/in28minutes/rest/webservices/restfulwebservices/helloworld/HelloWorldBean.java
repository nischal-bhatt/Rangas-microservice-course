package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {

	private String message;
	private MessageBean messageBean;

	public HelloWorldBean(String message)
	{
		this.message = message;
		this.messageBean = new MessageBean(message,3);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public MessageBean getMessageBean() {
		return messageBean;
	}

	public void setMessageBean(MessageBean messageBean) {
		this.messageBean = messageBean;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + ", messageBean=" + messageBean + "]";
	}
	
	
	
	
}
