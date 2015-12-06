package com.syntacticsugar.vooga.gameplayer.attribute.weapon;

import com.syntacticsugar.vooga.authoring.parameters.EditableClass;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.objects.items.bullets.BulletParams;
import com.syntacticsugar.vooga.gameplayer.objects.items.bullets.PlayerBullet;

import javafx.geometry.Point2D;

@EditableClass (
		className = "Basic Weapon"
		)
public class BasicWeaponAttribute extends AbstractWeaponAttribute {

	public BasicWeaponAttribute() {
		super();
	}
	
	@Override
	protected void setDefaults() {
		super.setDefaults();
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
