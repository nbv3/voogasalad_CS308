package com.syntacticsugar.vooga.gameplayer.attribute.weapon;


import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.objects.items.bullets.BulletParams;
import com.syntacticsugar.vooga.gameplayer.objects.items.bullets.PlayerBullet;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public class BasicWeaponAttribute extends AbstractWeaponAttribute {

	public BasicWeaponAttribute(String bulletImagePath, Double bulletDamage, KeyCode fireKeyCode,
			Double bulletSpeed, Double bulletWidth, Double bulletHeight) {
		super(bulletImagePath, bulletDamage, fireKeyCode, bulletSpeed, bulletWidth, bulletHeight);
	}
	
	protected IGameObject makeBullet() {
		PlayerBullet bullet = null;
		if (getParent().getType().equals(GameObjectType.PLAYER)) {
			Point2D bulletInitPos = new Point2D(getParent().getBoundingBox().getPoint().getX() + getParent().getBoundingBox().getWidth()/2,
											getParent().getBoundingBox().getPoint().getY() + getParent().getBoundingBox().getHeight()/2);
			BulletParams params = makeParams(bulletInitPos);
			bullet = new PlayerBullet(params);
			
		}
		
		return bullet;
	}
	
}
