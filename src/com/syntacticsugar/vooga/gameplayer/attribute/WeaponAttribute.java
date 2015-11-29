package com.syntacticsugar.vooga.gameplayer.attribute;

import com.syntacticsugar.vooga.gameplayer.attribute.control.IUserControlAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.algs.*;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.implementations.PlayerBullet;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.IObjectSpawner;
import com.syntacticsugar.vooga.gameplayer.universe.userinput.IKeyInputStorage;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public class WeaponAttribute extends AbstractAttribute implements IUserControlAttribute {

	private double myBulletDamage;
	private String myBulletImagePath;
	private KeyCode myFireKeyCode;
	private boolean isFireKeyPressed;
	
	private int fireFrameDelay;
	private int delayFrameCounter;
	
	public WeaponAttribute(String bulletImagePath, double bulletDamage, KeyCode fireKeyCode) {
		this.myBulletImagePath = bulletImagePath;
		this.myBulletDamage = -bulletDamage;
		this.myFireKeyCode = fireKeyCode;
		this.isFireKeyPressed = false;
		this.fireFrameDelay = 30;
		this.delayFrameCounter = 0;
	}
	
	@Override
	public void updateSelf(IGameUniverse universe) {
		updateKeyInput(universe);
		if (isFireKeyPressed) {
			if (fireConditionsMet()) {
				fireBullet(universe);
				delayFrameCounter = 0;
			}
		}
		delayFrameCounter++;
	}

	@Override
	public void updateKeyInput(IKeyInputStorage universeKeyInput) {
		 isFireKeyPressed = universeKeyInput.getCurrentKeyInput().contains(myFireKeyCode); 
	}

	@Override
	public void processKeyInput() {
		
	}

	private boolean fireConditionsMet() {
		return (delayFrameCounter > fireFrameDelay);
	}
	
	private void fireBullet(IObjectSpawner spawner) {
		if (getParent().getType().equals(GameObjectType.PLAYER)) {
			Point2D bulletInitPos = new Point2D(getParent().getBoundingBox().getPoint().getX() + getParent().getBoundingBox().getWidth()/2,
											getParent().getBoundingBox().getPoint().getY() + getParent().getBoundingBox().getHeight()/2);
			PlayerBullet bullet = 
					new PlayerBullet(getCurrentDirection(), 
									 bulletInitPos, 
									 myBulletImagePath, 
									 myBulletDamage);
			spawner.addToSpawnYard(bullet);
		}
	}
	
	private AbstractMovementType getCurrentDirection() {
		Direction dir = getParent().getBoundingBox().getDirection();
		AbstractMovementType move = null;
		switch (dir) {
			case LEFT :
				move = new MoveLeftCardinal();
				break;
			case RIGHT :
				move = new MoveRightCardinal();
				break;
			case UP :
				move = new MoveUpCardinal();
				break;
			case DOWN :
				move = new MoveDownCardinal();
				break;
		}
		return move;
	}
	
}
