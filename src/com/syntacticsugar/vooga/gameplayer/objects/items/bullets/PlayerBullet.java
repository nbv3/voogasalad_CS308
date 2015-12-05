package com.syntacticsugar.vooga.gameplayer.objects.items.bullets;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.ConstantMovementAttribute;
import com.syntacticsugar.vooga.gameplayer.event.implementations.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ObjectDespawnEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IBoundingBox;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

import javafx.geometry.Point2D;

public class PlayerBullet extends AbstractBullet {

	private boolean despawnFlag;
	
	public PlayerBullet(BulletParams params) {
		super(params);
		
	}
	
}
