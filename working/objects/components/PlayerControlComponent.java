package objects.components;

import java.util.Map;

import javafx.scene.input.KeyCode;
import objects.IGameObject;
import objects.events.EEventType;
import objects.events.IEvent;
import objects.events.PlayerControlEvent;
import objects.player.KeyInput;

public class PlayerControlComponent extends AbstractComponent implements IPlayerComponent {
	
	//Should player speed, direction, etc be in here?
	
	Map<KeyCode, KeyInput> myKeyMap;
	
	private KeyInput myInput;
	
	//Maybe this goes in a player subclass? If so just copy this stuff into that class

	public PlayerControlComponent(IGameObject parent) {
		super(parent);
		myInput = null;
	}

	@Override
	public void receiveEvent(IEvent e) {
		if (e.getType().equals(EEventType.PlayerControlEvent)){
			PlayerControlEvent event = (PlayerControlEvent) e;
			if (myKeyMap.containsKey(event.getKeyCode())) {
				myInput = myKeyMap.get(event.getKeyCode());
			}
		}
	}

	@Override
	public void update() {
		if (myInput != null) {
			myInput.run(this);
		}
		
		myInput = null;
	}
	
	public void move() {
		
	}

}
