package com.jason.safe_service.bean;

import java.lang.reflect.Parameter;

public class ArgumentAndParameter {
	private Object argument;
	private Parameter parameter;
	
	public ArgumentAndParameter(Parameter parameter, Object argument) {
		this.parameter = parameter;
		this.argument = argument;
	}
	
	public Parameter getParameter() {
		return parameter;
	}
	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}
	public Object getArgument() {
		return argument;
	}
	public void setArgument(Object argument) {
		this.argument = argument;
	}
	
	
}
