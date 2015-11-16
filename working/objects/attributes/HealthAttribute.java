package objects.attributes;

import java.util.ArrayList;
import java.util.List;

import objects.IGameObject;
import objects.events.DamageEvent;
import objects.events.EEventType;
import objects.events.IEvent;
import objects.events.ObjectDespawnEvent;

public class HealthAttribute extends AbstractAttribute {
	
	private double myMaxHealth;
	private double myCurrentHealth;
	
	private List<IEvent> onZeroLocalEvents;
	private List<IEvent> onZeroGlobalEvents;
	
	public HealthAttribute(IGameObject parent) {
		super(parent);
		onZeroLocalEvents = new ArrayList<>();
		onZeroGlobalEvents = new ArrayList<>();
		
		//TODO: REMOVE THIS
		onZeroGlobalEvents.add(new ObjectDespawnEvent(getParent()));
	}

	@Override
	public void receiveEvent(IEvent e) {
		if (e.getType().equals(EEventType.DamageEvent) && e.getTarget().equals(getParent())){
			DamageEvent dmg = (DamageEvent) e;
			changeHealth(dmg.getDamage());
		}
	}

	@Override
	public void update() {
		if (myCurrentHealth < 0) {
			for (IEvent event: onZeroLocalEvents) {
				getParent().sendEventToChildren(event);
			}
			
			for (IEvent event: onZeroGlobalEvents) {
				getPoster().postEvent(event);
			}
		}
	}
	
	public void addZeroLocalEvent (IEvent event) {
		onZeroLocalEvents.add(event);
	}
	
	public void addZeroGlobalEvent (IEvent event) {
		onZeroGlobalEvents.add(event);
	}
	
	private void changeHealth(double dmg) {
		myCurrentHealth -= dmg;
		if (myCurrentHealth > myMaxHealth) {
			myCurrentHealth = myMaxHealth;
		}
	}

}
