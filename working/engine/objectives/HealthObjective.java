package engine.objectives;

import java.util.Observable;

import objects.AbstractGameObject;
import objects.attributes.HealthAttribute;

public class HealthObjective extends Observable implements IObjective {

	private HealthAttribute observedHealth;
	private AbstractGameObject observedObject;

	public HealthObjective(AbstractGameObject object, HealthAttribute health) {
		observedObject = object;
		observedHealth = health;
		observedHealth.addObserver(this);
	}

	@Override
	public boolean hasAchieved() {
		return observedHealth.isDepleted();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o.equals(observedHealth)) {
			if (hasAchieved()) {
				takeAction();
			}
		}
	}

	@Override
	public void takeAction() {

	}

}
