package engine.objectives;

import java.util.Observable;

import engine.environment.IHandleObjective;
import objects.AbstractGameObject;
import objects.attributes.HealthAttribute;

public class HealthObjective implements IObjective {

	private HealthAttribute observedHealth;
	private AbstractGameObject observedObject;
	private IHandleObjective environmentRemover;

	public HealthObjective(AbstractGameObject object, HealthAttribute health, IHandleObjective environmentFunction) {
		observedObject = object;
		observedHealth = health;
		observedHealth.addObserver(this);
		environmentRemover = environmentFunction;
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
		environmentRemover.executeObjective(environment -> environment.removeFromEnvironment(observedObject));
	}

}
