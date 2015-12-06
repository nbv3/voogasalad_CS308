package com.syntacticsugar.vooga.gameplayer.attribute.weapon;

import java.util.ArrayList;
import java.util.Observable;

import com.syntacticsugar.vooga.authoring.parameters.AbstractParameter;
import com.syntacticsugar.vooga.authoring.parameters.DoubleParameter;
import com.syntacticsugar.vooga.authoring.parameters.IEditableParameter;
import com.syntacticsugar.vooga.authoring.parameters.KeyCodeParameter;
import com.syntacticsugar.vooga.authoring.parameters.StringParameter;
import com.syntacticsugar.vooga.gameplayer.attribute.AbstractAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.control.IUserControlAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ObjectSpawnEvent;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.objects.items.bullets.BulletParams;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.userinput.IKeyInputStorage;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public abstract class AbstractWeaponAttribute extends AbstractAttribute implements IUserControlAttribute {

	protected Double myBulletDamage;
	protected String myBulletImagePath;
	protected KeyCode myFireKeyCode;
	protected boolean isFireKeyPressed;
	
	protected Double myBulletSpeed;
	protected Double myBulletWidth;
	protected Double myBulletHeight;
	
	private Integer fireFrameDelay;
	private int delayFrameCounter;
	
	public AbstractWeaponAttribute(AbstractParameter<?>... params) {
		super(params);
		this.myBulletImagePath = "";
		this.myBulletDamage = 0.0;
		this.myFireKeyCode = KeyCode.SPACE;
		this.isFireKeyPressed = false;
		this.fireFrameDelay = 10;
		this.delayFrameCounter = 0;
		myBulletSpeed = 5.0;
		myBulletWidth = 10.0;
		myBulletHeight = 10.0;
	}
	
	public void setImagePath(String path){
		myBulletImagePath = path;
	}
	public void setBulletDamage(Double val)
	{
		myBulletDamage = val;
	}
	public void setBulletSpeed(Double val)
	{
		myBulletSpeed = val;
	}
	public void setFireKeyCode(KeyCode code)
	{
		myFireKeyCode = code;
	}
	
	@Override
	public void updateSelf(IGameUniverse universe) {
		updateKeyInput(universe);
		if (isFireKeyPressed) {
			if (fireConditionsMet()) {
				IGameObject bullet = makeBullet();
				fireBullet(universe, bullet);
				delayFrameCounter = 0;
			}
		}
		delayFrameCounter++;
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
	
	protected abstract IGameObject makeBullet();
	
	protected void fireBullet(IEventPoster poster, IGameObject bullet) {
		ObjectSpawnEvent event = new ObjectSpawnEvent(bullet);
		poster.postEvent(event);
	}
	
	protected Direction getCurrentDirection() {
		Direction dir = getParent().getBoundingBox().getDirection();
		return dir;
	}
	
	protected BulletParams makeParams(Point2D bulletInitPos) {
		BulletParams params = new BulletParams();
		params.setMove(getCurrentDirection());
		params.setStartPoint(bulletInitPos);
		params.setImagePath(myBulletImagePath);
		params.setSpeed(myBulletSpeed);
		params.setDamage(myBulletDamage);
		params.setWidth(myBulletWidth);
		params.setHeight(myBulletHeight);
		
		return params;
	}
	
	@Override
	abstract public void update(Observable o, Object arg);
	
}
