package com.syntacticsugar.vooga.gameplayer.objects.implementations;

import com.syntacticsugar.vooga.gameplayer.attribute.ConstantMovementAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.algs.AbstractMovementType;
import com.syntacticsugar.vooga.gameplayer.event.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

import javafx.geometry.Point2D;

public class PlayerBullet extends GameObject {

	public PlayerBullet(AbstractMovementType move, Point2D startPoint, String imagePath, double damage) {
		super(GameObjectType.ITEM, startPoint, 10, 10, imagePath);
		HealthChangeEvent bulletDamage = new HealthChangeEvent(damage);
		addAttribute(new ConstantMovementAttribute(move, 6));
		addCollisionBinding(GameObjectType.ENEMY, bulletDamage);
		for (IAttribute att: getAttributes().values()) {
			att.setParent(this);
		}
	}
	
}
