package objects.events;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PlayerControlEvent extends AbstractEvent{
	
	private KeyCode myCode;
	private KeyEvent myEvent;
	
	public PlayerControlEvent(KeyEvent event, KeyCode code){
		super(EEventType.PlayerControlEvent);
		
		myCode = code;
		myEvent = event;
	}
	
	public KeyCode getKeyCode() {
		return myCode;
	}
	
	public KeyEvent getKeyEvent() {
		return myEvent;
	}

}
