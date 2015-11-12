package objects.events;

import javafx.scene.input.KeyCode;

public class PlayerControlEvent extends AbstractEvent{
	
	private KeyCode myCode;
	
	public PlayerControlEvent(){
		super(EEventType.PlayerControlEvent);
	}
	
	public KeyCode getKeyCode() {
		return myCode;
	}

}
