package com.syntacticsugar.vooga.gameplayer.attribute.weapon;

import java.util.Observable;

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

public class BombAttribute extends AbstractAttribute implements IUserControlAttribute {
	
	protected double myDamage;
	protected String myImagePath;
	protected KeyCode myFireKeyCode;
	protected boolean isFireKeyPressed;
	protected int myDelay; 
	
	private Integer fireFrameDelay;
	private int delayFrameCounter;
	
	public BombAttribute() {
		myDamage = 0.0;
		myImagePath = null;
		myFireKeyCode = null;
		isFireKeyPressed = false;
		myDelay = 0;
		fireFrameDelay = 0;
		delayFrameCounter = 0;
	}
	
	public void setDamage(int damage) {
		myDamage = damage;
	}
	
	public double getDamage() {
		return myDamage;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

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
		TileDamageTemporaryEffect effect = new TileDamageTemporaryEffect(myDamage, myDelay);
		IGameMap map = universe.getMap(); 
		map.getTile(getParent().getPoint()).setTileEffect(effect);
		try {
			Point2D point = map.getCoordinateFromMapIndex(map.getMapIndexFromCoordinate(getParent().getPoint()));
			IGameObject obj = new GameObject(GameObjectType.ITEM, point, map.getTileSize(), map.getTileSize(), myImagePath);
			TimedDespawnAttribute timer = new TimedDespawnAttribute();
			timer.setTimeHere(myDelay);
			obj.addAttribute(timer);
			timer.setParent(obj);
			postBomb(universe, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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

}
