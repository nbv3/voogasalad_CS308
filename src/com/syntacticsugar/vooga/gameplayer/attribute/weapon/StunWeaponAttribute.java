package com.syntacticsugar.vooga.gameplayer.attribute.weapon;

import java.util.Observable;

import com.syntacticsugar.vooga.authoring.parameters.DoubleParameter;
import com.syntacticsugar.vooga.authoring.parameters.IntegerParameter;
import com.syntacticsugar.vooga.authoring.parameters.KeyCodeParameter;
import com.syntacticsugar.vooga.authoring.parameters.StringParameter;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.objects.items.bullets.BulletParams;
import com.syntacticsugar.vooga.gameplayer.objects.items.bullets.StunBullet;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public class StunWeaponAttribute extends AbstractWeaponAttribute {
	
	private Integer myStunTime;
	
	public StunWeaponAttribute() {
		super(new DoubleParameter("Bullet Damage: "), new DoubleParameter("Bullet Speed: "), new StringParameter("Image Path: "), new KeyCodeParameter("Fire KeyCode: "), new IntegerParameter("Stun Time: "));
		myStunTime = 0;
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
	
	public void setStunTime(Integer time)
	{
		myStunTime = time;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		try{
			Double value = (Double) arg;
			setChanged();
			notifyObservers(this);
		}
		catch (ClassCastException e)
		{
			try
			{
				KeyCode code = (KeyCode) arg;
				setFireKeyCode(code);
				setChanged();
				notifyObservers(this);
				
			}
			catch (ClassCastException e1)
			{
				try
				{
					String s = (String) arg;
					setImagePath(s);
					setChanged();
					notifyObservers(this);
				}
				catch (ClassCastException e2)
				{
					try
					{
						Integer val = (Integer) arg;
						setStunTime(val);
						setChanged();
						notifyObservers(this);
					}
					catch (ClassCastException e3)
					{
						
					}
				}

			}
			
		}

	}

}
