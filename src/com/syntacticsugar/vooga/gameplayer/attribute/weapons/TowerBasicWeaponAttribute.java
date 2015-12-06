package com.syntacticsugar.vooga.gameplayer.attribute.weapons;

import com.syntacticsugar.vooga.authoring.parameters.EditableClass;
import com.syntacticsugar.vooga.authoring.parameters.EditableField;
import com.syntacticsugar.vooga.authoring.parameters.InputParser;
import com.syntacticsugar.vooga.authoring.parameters.InputTypeException;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.objects.items.bullets.BulletParams;
import com.syntacticsugar.vooga.gameplayer.objects.items.bullets.PlayerBullet;
import com.syntacticsugar.vooga.gameplayer.objects.items.bullets.TowerBasicBullet;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

import javafx.geometry.Point2D;

@EditableClass (
		className = "Tower Basic Weapon"
		)
public class TowerBasicWeaponAttribute extends AbstractWeaponAttribute {
	
	private int fireRate;
	//private String dummy;
	
	private int myFrameCount;
	
	public TowerBasicWeaponAttribute() {
		super();
		myFrameCount = 0;
	}
	
	//public TowerBasicWeaponAttribute(TowerBasicWeaponAttribute tbwa) {
	//	this.dummy = tbwa.dummy;
	//}

	@Override
	protected IGameObject makeBullet() {
		TowerBasicBullet bullet = null;
		if (getParent().getType().equals(GameObjectType.TOWER)) {
			System.out.println(getParent().getBoundingBox().getWidth());
			//getParent().getBoundingBox().get
			Point2D bulletInitPos = new Point2D(getParent().getBoundingBox().getPoint().getX() + getParent().getBoundingBox().getWidth()/2.0,
											getParent().getBoundingBox().getPoint().getY() + getParent().getBoundingBox().getHeight()/2.0);
			BulletParams params = makeParams(bulletInitPos);
			bullet = new TowerBasicBullet(params);
			
		}
		return bullet;
	}
	
	@Override
	public void updateSelf(IGameUniverse universe) {
		if (fireConditionsMet()) {
			IGameObject bullet = makeBullet();
			fireBullet(universe, bullet);
			myFrameCount = 0;
		}
		
		myFrameCount++;
	}
	
	protected boolean fireConditionsMet() {
		return (myFrameCount >= fireRate);
	}
	
	/**		  	      EDIT TAGS	     		    **/
	/** *************************************** **/
	
	@EditableField
	(	inputLabel = "Fire rate",
		defaultVal = "30"	)
	private void editBulletDamage(String arg) {
		try {
			this.fireRate = InputParser.parseAsInt(arg);
		} catch (InputTypeException e) { 	}
	}

}
