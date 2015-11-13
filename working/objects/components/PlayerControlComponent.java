package objects.components;

import java.util.Map;
import java.util.Vector;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import objects.IGameObject;
import objects.events.EEventType;
import objects.events.IEvent;
import objects.events.PlayerControlEvent;
import objects.player.KeyInput;

public class PlayerControlComponent extends AbstractComponent implements IPlayer {
	
	private class KeyData {
		public KeyCode myCode;
		public Boolean myState;
		
		public KeyData(KeyCode code, Boolean s) {
			myCode = code;
			myState = s;
		}
	}
	
	Map<KeyData, KeyInput> myKeyMap;
	
	private KeyInput myInput;
	
	private double mySpeed;
	
	//This component will set the player's velocity to be this.
	private Vector<Double> myVelocity;
	
	//Maybe this goes in a player subclass? If so just copy this stuff into that class

	public PlayerControlComponent(IGameObject parent) {
		super(parent);
		myInput = null;
	}

	@Override
	public void receiveEvent(IEvent e) {
		if (e.getType().equals(EEventType.PlayerControlEvent)){
			PlayerControlEvent event = (PlayerControlEvent) e;
			Boolean isPressed;
			if (event.getKeyEvent().getEventType().equals(KeyEvent.KEY_PRESSED)){
				isPressed = true;
			}
			else {
				isPressed = false;
			}
			KeyData data = new KeyData(event.getKeyCode(), isPressed);
				
			if (myKeyMap.containsKey(data)) {
				myInput = myKeyMap.get(event.getKeyCode());
			}
		}
	}

	@Override
	public void update() {
		if (myInput != null) {
			myInput.run(this);
		}
		
		move();
		
		myInput = null;
	}
	
	public void move() {
		getParent().setVelocity(myVelocity);
	}
	
	public void setVelocity(Vector<Double> vel) {
		myVelocity = vel;
	}
	
	public void useItem(int itemNum) {
		
	}
	
	public double getSpeed() {
		return mySpeed;
	}

}
