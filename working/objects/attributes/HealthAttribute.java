package objects.attributes;

import objects.IGameObject;
import objects.events.DamageEvent;
import objects.events.EEventType;
import objects.events.IEvent;

public class HealthAttribute extends AbstractAttribute {
	
	private double myMaxHealth;
	private double myCurrentHealth;
	
	public HealthAttribute(IGameObject parent) {
		super(parent);
	}

	@Override
	public void receiveEvent(IEvent e) {
		if (e.getType().equals(EEventType.DamageEvent) && e.getTarget().equals(getParent())){
			DamageEvent dmg = (DamageEvent) e;
			myCurrentHealth -= dmg.getDamage();
		}
	}

	@Override
	public void update() {
		if (myCurrentHealth < 0) {
			getParent().setToDestroy();
		}
	}

}
