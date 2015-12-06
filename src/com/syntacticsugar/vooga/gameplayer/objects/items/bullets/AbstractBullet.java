package com.syntacticsugar.vooga.gameplayer.objects.items.bullets;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.ConstantMovementAttribute;
import com.syntacticsugar.vooga.gameplayer.event.implementations.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ObjectDespawnEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public abstract class AbstractBullet extends GameObject {
	
	private boolean despawnFlag;
	
	public AbstractBullet(BulletParams params) {
		super(GameObjectType.ITEM, params.getStartPoint(), params.getWidth(), params.getHeight(), params.getImagePath());
		HealthChangeEvent bulletDamage = new HealthChangeEvent(params.getDamage());
		addAttribute(new ConstantMovementAttribute(params.getMove(), params.getSpeed()));
		addCollisionBinding(GameObjectType.ENEMY, bulletDamage);
		for (IAttribute att: getAttributes().values()) {
			att.setParent(this);
		}
		despawnFlag = false;
	}
	
	@Override
	public void updateSelf(IGameUniverse universe) {
		super.updateSelf(universe);
		if (despawnFlag) {
			ObjectDespawnEvent event = new ObjectDespawnEvent(this);
			universe.postEvent(event);
		}
	};
	
	@Override
	public void onCollision(IGameObject obj){
		super.onCollision(obj);
		
		if (obj.getType().equals(GameObjectType.ENEMY)) {
			setDespawnFlag(true);
		}
	}
	
	protected void setDespawnFlag(boolean flag) {
		this.despawnFlag = flag;
	}

}
