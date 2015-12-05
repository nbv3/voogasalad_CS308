package com.syntacticsugar.vooga.gameplayer.attribute;


import java.util.Collection;
import java.util.Observable;

import com.syntacticsugar.vooga.authoring.parameters.DoubleParameter;
import com.syntacticsugar.vooga.authoring.parameters.IEditableParameter;
import com.syntacticsugar.vooga.authoring.parameters.KeyCodeParameter;
import com.syntacticsugar.vooga.authoring.parameters.StringParameter;
import com.syntacticsugar.vooga.gameplayer.attribute.control.IUserControlAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.items.bullets.PlayerBullet;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.IObjectSpawner;
import com.syntacticsugar.vooga.gameplayer.universe.userinput.IKeyInputStorage;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public class WeaponAttribute extends AbstractAttribute implements IUserControlAttribute {

	private Double myBulletDamage;
	private String myBulletImagePath;
	private KeyCode myFireKeyCode;
	private boolean isFireKeyPressed;
	
	private int fireFrameDelay;
	private int delayFrameCounter;
	
	public WeaponAttribute() {
		super(new StringParameter("Image Path:  "), new DoubleParameter("Bullet Damage: "), new KeyCodeParameter("Fire KeyCode: "));
		setParameters("", 10.0, KeyCode.SPACE);
	}
	
	private void setParameters(String path, Double damage, KeyCode code)
	{
		this.myBulletImagePath = path;
		this.myBulletDamage = -damage;
		this.myFireKeyCode = code;
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
	
	public void setBulletDamage(Double value)
	{
		myBulletDamage = value;
	}
	
	public void setBulletImagePath(String path)
	{
		myBulletImagePath = path;
	}
	
	public void setFireKeyCode(KeyCode code)
	{
		myFireKeyCode = code;
	}
	
	public String getImagePath()
	{
		return myBulletImagePath;
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
	
	private Direction getCurrentDirection() {
		Direction dir = getParent().getBoundingBox().getDirection();
		return dir;
	}

	@Override
	public void update(Observable o, Object arg) {
		try
		{
			KeyCode code = (KeyCode) arg;
			setFireKeyCode(code);
			
		}
		catch (ClassCastException e)
		{
			try
			{
				Double d = (Double) arg;
				setBulletDamage(d);
			}
			catch (ClassCastException e1)
			{
				try
				{
					String path = (String) arg;
					setBulletImagePath(path);
				}
				catch (ClassCastException e2)
				{
				
				}
				
			}
		}
		setChanged();
		notifyObservers(this);
	}

}
