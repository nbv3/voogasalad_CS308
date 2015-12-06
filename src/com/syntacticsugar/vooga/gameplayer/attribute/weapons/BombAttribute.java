package com.syntacticsugar.vooga.gameplayer.attribute.weapons;

import java.util.Observable;

import com.syntacticsugar.vooga.authoring.parameters.EditableClass;
import com.syntacticsugar.vooga.authoring.parameters.EditableField;
import com.syntacticsugar.vooga.authoring.parameters.InputParser;
import com.syntacticsugar.vooga.authoring.parameters.InputTypeException;
import com.syntacticsugar.vooga.gameplayer.attribute.AbstractAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.TimedDespawnAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.control.IUserControlAttribute;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ObjectSpawnEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.effects.TileDamageTemporaryEffect;
import com.syntacticsugar.vooga.gameplayer.universe.userinput.IKeyInputStorage;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

@EditableClass (
		className = "Bomb"
		)
public class BombAttribute extends AbstractAttribute implements IUserControlAttribute {
	
	protected double myDamage;
	protected String myImagePath;
	protected KeyCode myFireKeyCode;
	protected boolean isFireKeyPressed;
	protected int myFuse; 
	
	private Integer fireFrameDelay;
	private int delayFrameCounter;
	
	public BombAttribute() {
		super();
	}
	
	public BombAttribute(String bulletImagePath, Double bulletDamage, KeyCode fireKeyCode,
				Integer fuse, Integer fireDelay) {
		myImagePath = bulletImagePath;
		myDamage = bulletDamage;
		myFireKeyCode = fireKeyCode;
		myFuse = fuse;
		fireFrameDelay = fireDelay;
		
	}
	public void setDamage(int damage) {
		myDamage = damage;
	}
	
	public double getDamage() {
		return myDamage;
	}
	
	@Override
	protected void setDefaults() {
		myDamage = 30.0;
		myImagePath = "scenery_black.png";
		myFireKeyCode = KeyCode.SPACE;
		isFireKeyPressed = false;
		myFuse = 60;
		fireFrameDelay = 90;
		delayFrameCounter = 0;
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		updateKeyInput(universe);
		if (isFireKeyPressed) {
			if (fireConditionsMet()) {
				makeBomb(universe);
				delayFrameCounter = 0;
			}
		}
		delayFrameCounter++;
	}
	
	private void makeBomb(IGameUniverse universe) {
		TileDamageTemporaryEffect effect = new TileDamageTemporaryEffect(myDamage, myFuse);
		effect.setHitImagePath("scenery_black.png");
		effect.setImagePersistenceLength(20);
		IGameMap map = universe.getMap(); 
		Point2D tpoint = getParent().getPoint();
		try {
			map.getTileFromIJ(map.getMapIndexFromCoordinate(tpoint)).setTileEffect(effect);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			Point2D point = map.getCoordinateFromMapIndex(map.getMapIndexFromCoordinate(getParent().getPoint()));
			IGameObject obj = new GameObject(GameObjectType.ITEM, point, map.getTileSize(), map.getTileSize(), myImagePath);
			TimedDespawnAttribute timer = new TimedDespawnAttribute();
			timer.setTimeHere(myFuse);
			obj.addAttribute(timer);
			timer.setParent(obj);
			postBomb(universe, obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void postBomb(IEventPoster poster, IGameObject obj) {
		ObjectSpawnEvent event = new ObjectSpawnEvent(obj);
		poster.postEvent(event);
	}
	
	@Override
	public void updateKeyInput(IKeyInputStorage universeKeyInput) {
		 isFireKeyPressed = universeKeyInput.getCurrentKeyInput().contains(myFireKeyCode); 
	}
	
	private boolean fireConditionsMet() {
		return (delayFrameCounter > fireFrameDelay);
	}

	@Override
	public void processKeyInput() {
		
	}
	
	/**		  	      EDIT TAGS	     		    **/
	/** *************************************** **/
	
	@EditableField
	(	inputLabel = "Bullet Damage",
		defaultVal = "10"	)
	private void editBulletDamage(String arg) {
		try {
			this.myDamage = InputParser.parseAsDouble(arg);
		} catch (InputTypeException e) { 	}
	}

	@EditableField
	(	inputLabel = "Fire Button",
		defaultVal = "SPACE"	)
	private void editFireCode(String arg) {
		try {
			this.myFireKeyCode = InputParser.parseAsKeyCode(arg);
		} catch (InputTypeException e) {	}
	}

	@EditableField
	(	inputLabel = "Bullet Image Path",
		defaultVal = "scenery_black.png"	)
	private void editBulletImage(String arg) {
		try {
			this.myImagePath = InputParser.parseAsImagePath(this.getClass().getClassLoader(), arg);
		} catch (InputTypeException e) {	}
	}
	
	@EditableField
	(	inputLabel = "Fire Delay (# Frame)",
		defaultVal = "90"	)
	private void editFireDelay(String arg) {
		try {
			this.fireFrameDelay = InputParser.parseAsInt(arg);
		} catch (InputTypeException e) {	}
	}
	
	@EditableField
	(	inputLabel = "Bomb Fuse (# Frame)",
		defaultVal = "60"	)
	private void editFuse(String arg) {
		try {
			this.myFuse = InputParser.parseAsInt(arg);
		} catch (InputTypeException e) {	}
	}


}
