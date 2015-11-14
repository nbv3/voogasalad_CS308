package objects.attributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import objects.IGameObject;
import objects.events.EEventType;
import objects.events.IEvent;
import objects.events.PlayerControlEvent;
import objects.player.KeyInput;
import objects.player.MoveDownStart;
import objects.player.MoveLeftStart;
import objects.player.MoveRightStart;
import objects.player.MoveStop;
import objects.player.MoveUpStart;

public class PlayerControlAttribute extends AbstractAttribute implements IPlayer {
	
	private final Map<KeyCode, KeyInput> myKeyMap;
	private List<KeyInput> myInputEvents;
	private double mySpeed;
	//This attribute will set the player's velocity to be this.
	private double xVel;
	private double yVel;
	
	//Maybe this goes in a player subclass? If so just copy this stuff into that class

	public PlayerControlAttribute(IGameObject parent) {
		super(parent);
		initVelocity();
		myInputEvents = new ArrayList<KeyInput>();
		myKeyMap = new HashMap<KeyCode, KeyInput>();
		//TODO:DELETE THIS
		mySpeed = 1;
		addBinding(KeyCode.LEFT, new MoveLeftStart());
		addBinding(KeyCode.RIGHT, new MoveRightStart());
		addBinding(KeyCode.UP, new MoveUpStart());
		addBinding(KeyCode.DOWN, new MoveDownStart());
	}
	
	private void initVelocity() {
		xVel = 0;
		yVel = 0;
	}
	
	public void addBinding(KeyCode code, KeyInput input) {
		myKeyMap.put(code, input);
	}

	@Override
	public void receiveEvent(IEvent e) {
		if (e.getType().equals(EEventType.PlayerControlEvent)){
			PlayerControlEvent event = (PlayerControlEvent) e;
			myInputEvents.clear();
			for (KeyCode code : event.getKeyCodes()) {
				if (myKeyMap.containsKey(code)) {
					myInputEvents.add(myKeyMap.get(code));
				}
			}
			initVelocity();
			processKeyInput();
		}
	}

	@Override
	public void update() {
		move();
	}

	/**
	 * Run every key input event that was passed down from the GUI
	 */
	private void processKeyInput() {
		for (KeyInput k: myInputEvents) {
			k.run(this);
		}
	}
	
	public void move() {
		getParent().setVelocity(xVel, yVel);
	}
	
	@Override
	public void setVelocity(double dx, double dy) {
		xVel = dx;
		yVel = dy;
	}
	
	@Override
	public void setX(double dx) {
		xVel = dx;
	}
	
	@Override
	public void setY(double dy) {
		yVel = dy;
	}
	
	public void useItem(int itemNum) {
		
	}
	
	public double getSpeed() {
		return mySpeed;
	}

}
