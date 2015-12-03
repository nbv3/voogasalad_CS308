package com.syntacticsugar.vooga.authoring.objectediting;

public interface IDataDisplay<T> {

	public void displayData(T data);
	
	public void clearDisplay();
	
	public T getData();
	
}
