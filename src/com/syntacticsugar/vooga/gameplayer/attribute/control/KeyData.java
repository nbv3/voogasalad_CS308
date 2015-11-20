package com.syntacticsugar.vooga.gameplayer.attribute.control;

import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyData {

	private KeyCode myCode;
	private EventType<KeyEvent> myType;
	
	public KeyData(KeyCode code, EventType<KeyEvent> type) {
		this.myCode = code;
		this.myType = type;
	}
	
	public KeyCode getKeyCode() {
		return this.myCode;
	}
	
	public EventType<KeyEvent> getKeyEventType() {
		return this.myType;
	}
	
	@Override
	public int hashCode() {
		return this.myCode.hashCode()*31 + this.myType.hashCode()*71;
	}
	
	@Override
	public boolean equals(Object o) {
		try {
			KeyData data = (KeyData) o;
			return data.myCode == this.myCode && data.myType == this.myType;
		}
		catch (Exception e) {
			return false;
		}
	}
	
}
