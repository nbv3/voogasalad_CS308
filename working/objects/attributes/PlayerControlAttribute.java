package objects.attributes;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import objects.IGameObject;
import objects.events.EEventType;
import objects.events.IEvent;
import objects.events.PlayerControlEvent;
import objects.player.KeyInput;
import objects.player.MoveLeftStart;
import objects.player.MoveStop;

public class PlayerControlAttribute extends AbstractAttribute implements IPlayer {
	
	private class KeyData {
		public KeyCode myCode;
		public Boolean myState;
		
		public KeyData(KeyCode code, Boolean s) {
			myCode = code;
			myState = s;
		}
		
		@Override
		public int hashCode() {
			return 13 * myCode.getName().hashCode() + 19 * myState.hashCode();
		}
		
		@Override
		public boolean equals(Object o) {
			KeyData data = (KeyData) o;
			return myCode.equals(data.myCode) && myState.equals(data.myState);
		}
	}
	
	Map<KeyData, KeyInput> myKeyMap;
	
	private KeyInput myInput;
	
	private double mySpeed;
	
	//This attribute will set the player's velocity to be this.
	private Vector<Double> myVelocity;
	
	//Maybe this goes in a player subclass? If so just copy this stuff into that class

	public PlayerControlAttribute(IGameObject parent) {
		super(parent);
		initVelocity();
		myInput = null;
		
		
		myKeyMap = new HashMap<KeyData, KeyInput>();
		
		//TODO:DELETE THIS
		mySpeed = 1;
		addBinding(KeyCode.LEFT, true, new MoveLeftStart());
		addBinding(KeyCode.LEFT, false, new MoveStop());
	}
	
	private void initVelocity() {
		myVelocity = new Vector<Double>();
		myVelocity.add(0.0);
		myVelocity.add(0.0);
	}
	
	public void addBinding(KeyCode code, Boolean pressed, KeyInput input) {
		KeyData data = new KeyData(code, pressed);
		System.out.println(data.hashCode());
		myKeyMap.put(data, input);
		System.out.println(myKeyMap.containsKey(data));
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
			System.out.println(data.hashCode());
				
			if (myKeyMap.containsKey(data)) {
				myInput = myKeyMap.get(data);
			}
		}
	}

	@Override
	public void update() {
		if (myInput != null) {
			myInput.run(this);
			System.out.println("HAPPENING");
		}
		
		move();
		
		myInput = null;
	}
	
	public void move() {
		getParent().setVelocity(myVelocity.get(0), myVelocity.get(1));
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
