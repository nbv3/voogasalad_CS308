package com.syntacticsugar.vooga.gameplayer.attribute.weapon;

import java.util.Observable;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.objects.items.bullets.BulletParams;
import com.syntacticsugar.vooga.gameplayer.objects.items.bullets.SlowBullet;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public class SlowWeaponAttribute extends AbstractWeaponAttribute {

	private double mySpeedDecrease;
	private int myTime;

	public SlowWeaponAttribute(String bulletImagePath, Double bulletDamage, KeyCode fireKeyCode, Double bulletSpeed,
			Double bulletWidth, Double bulletHeight, Double speedDecrease, Integer time) {
		super(bulletImagePath, bulletDamage, fireKeyCode, bulletSpeed, bulletWidth, bulletHeight);
		mySpeedDecrease = speedDecrease;
		myTime = time;
	}

	@Override
	protected IGameObject makeBullet() {

		SlowBullet bullet = null;
		if (getParent().getType().equals(GameObjectType.PLAYER)) {
			Point2D bulletInitPos = new Point2D(
					getParent().getBoundingBox().getPoint().getX() + getParent().getBoundingBox().getWidth() / 2,
					getParent().getBoundingBox().getPoint().getY() + getParent().getBoundingBox().getHeight() / 2);
			BulletParams params = makeParams(bulletInitPos);
			bullet = new SlowBullet(params, mySpeedDecrease, myTime);

		}

		return bullet;
	}

	@Override
	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers(this);
	}

}
