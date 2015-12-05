package com.syntacticsugar.vooga.gameplayer.attribute.weapon;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.objects.items.bullets.BulletParams;
import com.syntacticsugar.vooga.gameplayer.objects.items.bullets.StunBullet;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public class StunWeaponAttribute extends AbstractWeaponAttribute {
	
	private int myStunTime;
	
	public StunWeaponAttribute(String bulletImagePath, Double bulletDamage, KeyCode fireKeyCode,
			Double bulletSpeed, Double bulletWidth, Double bulletHeight, Integer stunTime) {
		super(bulletImagePath, bulletDamage, fireKeyCode, bulletSpeed, bulletWidth, bulletHeight);
		myStunTime = stunTime;
	}

	@Override
	protected IGameObject makeBullet() {
		StunBullet bullet = null;
		if (getParent().getType().equals(GameObjectType.PLAYER)) {
			Point2D bulletInitPos = new Point2D(getParent().getBoundingBox().getPoint().getX() + getParent().getBoundingBox().getWidth()/2,
											getParent().getBoundingBox().getPoint().getY() + getParent().getBoundingBox().getHeight()/2);
			BulletParams params = makeParams(bulletInitPos);
			bullet = new StunBullet(params, myStunTime);
			
		}
		
		return bullet;
	}

}
